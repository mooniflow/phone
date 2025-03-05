
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import PhoneinfoView from "./components/PhoneinfoView"
import PhoneinfoViewDetail from "./components/PhoneinfoViewDetail"
import ReportReportManager from "./components/listers/ReportReportCards"
import ReportReportDetail from "./components/listers/ReportReportDetail"

import PhonemanagementPhonemanagementManager from "./components/listers/PhonemanagementPhonemanagementCards"
import PhonemanagementPhonemanagementDetail from "./components/listers/PhonemanagementPhonemanagementDetail"

import AlarmAlarmManager from "./components/listers/AlarmAlarmCards"
import AlarmAlarmDetail from "./components/listers/AlarmAlarmDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/monitorings/phoneinfos',
                name: 'PhoneinfoView',
                component: PhoneinfoView
            },
            {
                path: '/monitorings/phoneinfos/:id',
                name: 'PhoneinfoViewDetail',
                component: PhoneinfoViewDetail
            },
            {
                path: '/reports/reports',
                name: 'ReportReportManager',
                component: ReportReportManager
            },
            {
                path: '/reports/reports/:id',
                name: 'ReportReportDetail',
                component: ReportReportDetail
            },

            {
                path: '/phonemanagements/phonemanagements',
                name: 'PhonemanagementPhonemanagementManager',
                component: PhonemanagementPhonemanagementManager
            },
            {
                path: '/phonemanagements/phonemanagements/:id',
                name: 'PhonemanagementPhonemanagementDetail',
                component: PhonemanagementPhonemanagementDetail
            },

            {
                path: '/alarms/alarms',
                name: 'AlarmAlarmManager',
                component: AlarmAlarmManager
            },
            {
                path: '/alarms/alarms/:id',
                name: 'AlarmAlarmDetail',
                component: AlarmAlarmDetail
            },



    ]
})
