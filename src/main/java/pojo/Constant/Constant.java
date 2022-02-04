package pojo.Constant;

import Base.TestBase;

public class Constant extends TestBase {

    public static String SaveChannel_EndPoint = "/channel";
    public static String KnowledgeBase_EndPoint = "/knowledgebase";
    public static String GetKnowledgeBase_EndPoint = "/knowledgebase/2/?mode=text";
    public static String GetKnowledgeBase400_EndPoint = "/knowledgebase/0/?mode=text";
    public static String GetUserSessionMessage_EndPoint = "/user/session/fd840300850c1610099107553/5";
    public static String GetUserSessionMessage404_EndPoint = "/user/session/fd840300850c1610099107553";
    public static String users_messagesBot_EndPoint = "/user/messages/?page_size=10";
    public static String GetUsersByLatestMessageEnrolled_EndPoint = "/user/messages/recent/?agent_id=3&platform=facebook&enrolled=true";
    public static String GetUsersByLatestMessageNotEnrolled_EndPoint = "/user/messages/recent/?agent_id=4&enrolled=false";
    public static String SearchUser_EndPoint = "/user/search/";
    public static String SendNotification_EndPoint = "/message/send";
    public static String SendNotificationTemplateID_EndPoint = "/message/send/template";
    public static String GetNomatchedMessages_EndPoint = "/messages/nomatch/2/false/?page=1&page_size=20";
    public static String UpDateNoMessage_EndPoint = "/messages/nomatch/";
    public static String SendTemplateMessageOnly_EndPoint = "/message/send/template";
    public static String GetIntent_EndPoint = "/intent/?agent_id=3";
    public static String DetectIntent_EndPoint = "/message/detect_intent";
    public static String GetUserInfo_EndPoint = "/user/info?identifier=toyosio@ebanqo.com&agent_id=1";
    public static String CreateUser_EndPoint = "/user";
    public static String TriggerIntent_EndPoint = "/message/trigger/intent";
    public static String MessageReply_EndPoint = "/message/reply/";
    public static String GetLocation_EndPoint = "/user/location/2";
    public static String Gettemplate_EndPoint = "/message/template/2";
    public static String GetNotification_EndPoint = "/messages/notification/6/?page=1&page_size=10";
    public static String GetAgentStakeHolder_EndPoint = "/agent/stakeholder/wipay";
    public static String TriggerIntentClient_EndPoint = "/intent/trigger";
    public static String GetUserInformation_Client_EndPoint = "/user/infomation?identifier=toyosio@ebanqo.com&agent_code=TCFDemo908";
    public static String GetSub_EndPoint = "/user/subscribed/2/?page=1&page_size=20";
    public static String GetServicePag_EndPoint = "/services/?agent_id=3&page=1&page_size=20";
    public static String AddPhrase_EndPoint = "/services/8";
    public static String GettrainingSet_EndPoint = "/services/phrases/7";
    public static String Dashboard_Service_EndPoint = "/dashboard/services/3/?startdate=2019-12-15&enddate=2022-02-03";
    public static String NotificationBatch_EndPoint = "/messages/notification/grouped/1/?page=1&page_size=20&start_date=2019-01-01&end_date=2022-12-31";
    public static String NotificationByBatch_EndPoint = "/messages/notification/batch/2c27d6febe7743df14fdc15c90085bc800a2cbc01572346551356/?page=1&page_size=20";
    public static String SearchServices_EndPoint = "/services/search/3/?page=1&page_size=20&text=Account";
    public static String SearchKnowledgeBase_EndPoint = "/knowledgebase/search/1/?page=1&page_size=20&text=faqs";
    public static String SearchFailedResponse_EndPoint = "/failedresponse/search/12/?page=1&page_size=20&text=whatsapp";
    public static String SearchFailedResponseDate_EndPoint = "/failedresponse/bydate/3/true/?page=1&page_size=20&startdate=2020-01-01&enddate=2020-02-04";
    public static String GetQueueList_EndPoint = "/support/queue/5";
    public static String GetActiveAgentSupport_EndPoint = "/support/activeagent/5";
    public static String GetSessionSupport_EndPoint = "/support/mysession/5/1";
    public static String AddUserToQueue_EndPoint = "/support/joinqueue";
    public static String AcceptUserChat_EndPoint = "/support/assign";
    public static String SendMessageSupport_EndPoint = "/support/sendmessage";
    public static String EndSupportChat_EndPoint = "/support/accept";
    public static String Get_WebChat_Last_Session_EndPoint = "/user/webchat/messages";
    public static String CreateUser_Session_EndPoint = "/user/webchat/messages";
    public static String Create_KB_Dialogue_Flow_EndPoint = "/knowledgebasefromdatabase";
    public static String WhatApp_OptIn_EndPoint = "/gupshup/optin";
    public static String WhatApp_OptOut_EndPoint = "/gupshup/optout";
    public static String UpdateUserArchive_EndPoint = "/user/updateArchive";
    public static String GetSessionArchive_EndPoint = "/user/sessionarchive/?agent_id=2&archive_value=toyobaba";
    public static String GetAgentSession_EndPoint = "/settings/user/5";
    public static String GetAgent_EndPoint = "/settings/admin/1";
    public static String SetUPTemplate_EndPoint = "/template";
    public static String GetAgentID_EndPoint = "/agent/15";
    public static String GetUserSessionWebhookEndPoint = "/user/currentsession/5/fd840300850c1610099107553/webchat";
    public static String GetSettingName_EndPoint = "/settings/config/5/SUPPORT_EMAIL";
    public static String GetCurrentSession_EndPoint = "/user/currentsession/3/3320976204641799/facebook";
    public static String webchatmessageHistory_EndPoint = "/user/webchat/messages/";
    public static String CreateTeam_EndPoint = "/teams";
    public static String ListTeam_EndPoint = "/teams/2";
    public static String UpdateTeam_EndPoint = "/teams/28";
    public static String ActivateTeam_EndPoint = "/teams/activate/22/1";
    public static String Listgoogle_EndPoint = "/google-project";
    public static String GetUserSessionWebhookEndPointt = "/user/currentsession/5/fd840300850c161009910755333/webchat";


}