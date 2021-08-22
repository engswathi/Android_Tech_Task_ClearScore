package com.example.androidtectask.Model

data class CreditReportDatas(
    val accountIDVStatus: String,
    val augmentedCreditScore: Any,
    val coachingSummary: CoachingSummary,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String
)