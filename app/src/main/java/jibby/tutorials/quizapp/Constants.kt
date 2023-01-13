package jibby.tutorials.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Austria",
            "Alabama",
            1,
        )
        questionsList.add(question1)

        val question2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belgium",
            "Brazil",
            "Zimbabwe",
            "Cairo",
            2,
        )
        questionsList.add(question2)

        val question3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Fiji",
            "Denmark",
            "Eurasia",
            "Mexico",
            2,
        )
        questionsList.add(question3)

        val question4= Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Indiana",
            "Scotland",
            "Ireland",
            "India",
            4,
        )
        questionsList.add(question4)

        val question5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Denmark",
            "Russia",
            "China",
            1,
        )
        questionsList.add(question5)

        val question6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Japan",
            "Jamaica",
            "Switzerland",
            "Kuwait",
            4,
        )
        questionsList.add(question6)

        val question7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Hampshire",
            "United Kingdom",
            "New Mexico",
            "New Zealand",
            4,
        )
        questionsList.add(question7)

        val question8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Palestine",
            "Fiji",
            "Philippines",
            "France",
            2,
        )
        questionsList.add(question8)

        val question9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Berkshire",
            "Belgium",
            "Croatia",
            "Jamaica",
            2,
        )
        questionsList.add(question9)

        val question10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Austria",
            "Australia",
            "Arkansas",
            "Uranus",
            2,
        )
        questionsList.add(question10)

        return questionsList
    }

}