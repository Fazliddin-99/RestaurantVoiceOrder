# Restaurant Voice Order App

Order any food that is on the menu just using your voice!
This app was built for a hackathon competition in 2 days.

* In the starting page there're a horizontal RecyclerView for food list and a vertical one for restaurants list

![First screen](images/1.png)

* As you click the middle button on the bottom navigation bar, you'll get to the screen where the app start speaking and receiving your voice order. I used uzbek text-to-speech API and android's RecognizerIntent for recognizing user speech

![Second screen](images/2.png)

* Finally on the last page you can see the orders that you made in the second page and finalize your orders

![Third screen](images/3.png)

* Used architecture: MVVM

![Architecture](images/code.png)