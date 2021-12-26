package com.fazliddin.restaurantreservationmilliyintellekt.presentation.ui.voiceorder

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.AnimationDrawable
import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fazliddin.restaurantreservationmilliyintellekt.R
import com.fazliddin.restaurantreservationmilliyintellekt.databinding.FragmentVoiceOrderBinding
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.speech.RecognizerIntent
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.fazliddin.restaurantreservationmilliyintellekt.data.models.OrderListItem
import com.fazliddin.restaurantreservationmilliyintellekt.domain.stringsAreSame
import java.io.IOException

private const val REQUEST_RECORD_AUDIO_PERMISSION = 200
private const val LOG_TAG = "AudioRecord"
private const val SPEECH_REQUEST_CODE = 0

class VoiceOrderFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private var recorder: MediaRecorder? = null
    private val animation = AnimationDrawable()
    private var permissionToRecordAccepted = false
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)
    private var fileName: String = ""
    private var orderStage = 0
    private var orderText = ""
    private var currentOrderedMeal: String? = null
    private var currentOrderedQuantity: Int? = null
    private val ordersList: MutableList<OrderListItem> = mutableListOf()
    private val foodsList: List<String> = listOf(
        "OSH",
        "SOMSA",
        "MANTI",
        "LAG'MON",
        "MASTAVA",
        "NORIN",
        "SHASHLIK",
        "GRIL",
        "KABOB",
        "PALOV",
        "SHORVA",
        "SHO'RVA",
        "QOVURMA LAG'MON",
        "MAKARON",
        "DOLMA",
        "DO'LMA",
        "QOZON KABOB",
        "DIMLAMA",
        "CHUCHVARA",
        "MOSHXO'RDA"
    )

    private val numbers: HashMap<String, Int> =
        hashMapOf(
            "BIR" to 1,
            "1" to 1,
            "IKKI" to 2,
            "2" to 2,
            "UCH" to 3,
            "3" to 3,
            "TORT" to 4,
            "TO'RT" to 4,
            "4" to 4,
            "BESH" to 5,
            "5" to 5
        )

    private val positiveAnswers =
        arrayOf(
            "HA",
            "XA",
            "MAYLI",
            "HOP",
            "HUP",
            "HO'P",
            "XO'P",
            "XUP",
            "XOP",
            "MASLAXAT BER",
            "ALBATTA",
            "SHUNDAY",
            "TASDIQLAYMAN",
            "TO'G'RI",
            "TOG'RI",
            "TOGRI",
            "BO'LADI",
            "BOLADI",
            "YAXSHI",
            "YAHSHI",
            "YAXSHI BO'LARDI",
            "ZO'R",
            "DAVAY"
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVoiceOrderBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner

        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim1), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim2), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim3), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim4), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim5), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim6), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim7), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim8), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim9), 250)
        animation.addFrame(resources.getDrawable(R.drawable.ai_voice_anim10), 250)

        tts(
            "Assalomu alaykum. Rayhonga xush kelibsiz. \n" +
                    "Xo'sh, qanday taom buyurtma bermoqchisiz?\n" +
                    "Xohlasangiz eng yaxshilarini tavsiya qilaymi?"
        )

        // Record to the external cache directory for visibility
        fileName = "${requireActivity().externalCacheDir?.absolutePath}/audiorecordtest.3gp"

        ActivityCompat.requestPermissions(
            requireActivity(),
            permissions,
            REQUEST_RECORD_AUDIO_PERMISSION
        )
        binding.aiVoiceAnim.setImageDrawable(animation)

        return binding.root
    }

    private fun tts(text: String) {
        val audioUrl = "https://internal.nutq.uz/api/v1/cabinet/synthesize/?t=$text"

        // initializing media player
        mediaPlayer = MediaPlayer()

        mediaPlayer?.setOnCompletionListener {
            animation.stop()
            if (orderStage != 99)
                displaySpeechRecognizer()
            else
                findNavController().navigate(
                    VoiceOrderFragmentDirections.actionVoiceOrderFragmentToOrdersFragment(
                        ordersList.toTypedArray()
                    )
                )
        }

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer?.setDataSource(audioUrl)
            // below line is use to prepare
            // and start our media player.
            mediaPlayer?.setPlaybackParams(mediaPlayer?.getPlaybackParams()?.setSpeed(1.20f)!!);
            mediaPlayer?.prepare()
            mediaPlayer?.start()
            animation.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun stt(): String {
        startRecording()
        return ""
    }

    override fun onStop() {
        recorder?.release()
        recorder = null

        mediaPlayer?.release()
        mediaPlayer = null
        super.onStop()
    }

    private fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setMaxDuration(5000)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)

            try {
                prepare()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }

            start()
        }
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
    }

    private fun displaySpeechRecognizer() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
        }
        // This starts the activity and populates the intent with the speech text.
        startActivityForResult(intent, SPEECH_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                    results?.get(0)
                }

            spokenText?.let {
                orderText = it.uppercase()
            }

            continueTakingOrder()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun continueTakingOrder() {
        if (orderStage == 0) {
            orderStage++

            if (answerIsPositive()) {

                val foods: String = foodsList.shuffled().let {
                    "${it[0]},${it[1]},${it[2]},${it[3]},${it[4]}, ${it[5]}, shaxsan o'zim " +
                            "${it[3]} ni tavsiya qilaman. Qaysi taomni buyurtma qilasiz?"
                }
                tts(foods)
            } else {
                tts("Unda qaysi taomni buyurtma bermoqchisiz?")
            }

        } else if (orderStage == 1) {
            var foundMeal: String? = null

            for (food in foodsList) {
                if (stringsAreSame(food, orderText)) {
                    foundMeal = food
                    break
                }
            }

            if (foundMeal == null) {
                tts("Kechirasiz, ilg'ab ololmadim. Iltimos takrorlab yurboring.")
            } else {
                orderStage++
                tts("Xo'p, $foundMeal necha kishi uchun buyurtma beramiz?")
                currentOrderedMeal = foundMeal
            }

        } else if (orderStage == 2) {
            val number = numbers[orderText]

            if (number == null)
                tts("Kechirasiz, ilg'ab ololmadim. Iltimos takrorlab yurboring.")
            else {
                orderStage++
                tts("Tushunarli, $number kishi uchun. Ajoyib rahmat. Yana buyurtma berishni xohlaysizmi ?")
                currentOrderedQuantity = number
            }

        } else if (orderStage == 3) {
            currentOrderedMeal?.let { meal ->
                currentOrderedQuantity?.let { quantity ->
                    val order = OrderListItem(meal, quantity)
                    ordersList.add(order)
                }
            }

            currentOrderedMeal = null
            currentOrderedQuantity = null

            if (answerIsPositive()) {
                orderStage = 1
                tts("Qaysi taomni buyurtma bermoqchisiz?")
            } else {
                orderStage = 99
                tts("Tushunarli rahmat. Iltimos buyurtmangiz ma'lumotlarini tasdiqlang.")
            }

        }
    }

    private fun answerIsPositive(): Boolean {
        for (posAnswer in positiveAnswers) {
            if (stringsAreSame(posAnswer, orderText)) {
                return true
            }
        }

        return false
    }
}