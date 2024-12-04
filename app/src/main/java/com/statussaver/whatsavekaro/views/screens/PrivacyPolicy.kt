package com.statussaver.whatsavekaro.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.material.expandable.ExpandableWidget
import com.statussaver.whatsavekaro.utils.Preferences

@Composable
fun PrivacyPolicy(navController: NavController){
    val verticalScroll = rememberScrollState()
    val context = LocalContext.current

    val preferences =  Preferences(context)
    var selectedLang by remember { mutableStateOf(preferences.getSelectedLanguage()) }

    val privacyPolicies = mapOf(
        "English" to listOf(
            "Privacy Policy for WhatsApp Status Saver",
            "Effective Date: October 8, 2024",
            "Welcome to WhatSaveKaro (the “Status Saver”). Your privacy is important to us. This Privacy Policy explains how we collect, use, and protect your personal information when you use our App.",
            "1. Information We Collect:",
            "- Personal Information: We do not collect any personal information that can identify you, such as your name, email address, or phone number.",
            "- Usage Data: We may collect information on how you access and use the App, including your device's IP address and usage patterns.",
            "- Media Files: The App allows you to download and save status updates from WhatsApp, but we do not collect or store any media files on our servers.",
            "2. How We Use Your Information:",
            "- To Provide and Maintain Our App: We use your usage data to maintain and improve the functionality of our App.",
            "- To Monitor Usage: We use usage data to enhance user experience and address issues promptly.",
            "- To Communicate with You: We may send you updates related to the App, but we do not collect personal information for this purpose.",
            "3. How We Share Your Information:",
            "- With Your Consent: We may share your information with third parties if you provide explicit consent.",
            "- Legal Requirements: We may disclose your information if required by law or in response to valid requests by public authorities.",
            "4. Data Security:",
            "The security of your data is important to us. We implement reasonable security procedures to protect your information from unauthorized access.",
            "5. Children's Privacy:",
            "Our App does not address anyone under the age of 13. We do not knowingly collect personally identifiable information from children under 13. If you are a parent or guardian and you are aware that your child has provided us with personal data, please contact us.",
            "If you have any questions about this Privacy Policy, please contact us at: amannishad0512@gmail.com"
        ),

        "Hindi" to listOf(
            "व्हाट्सएप स्टेटस सेवेर के लिए गोपनीयता नीति",
            "प्रभावी तिथि: 8 अक्टूबर, 2024",
            "व्हाटसेवकारो (\"स्टेटस सेवेर\") में आपका स्वागत है। आपकी गोपनीयता हमारे लिए महत्वपूर्ण है। यह गोपनीयता नीति यह स्पष्ट करती है कि जब आप हमारे ऐप का उपयोग करते हैं, तो हम आपकी व्यक्तिगत जानकारी को कैसे एकत्रित, उपयोग और सुरक्षित रखते हैं।",
            "1. हम कौन सी जानकारी एकत्रित करते हैं:",
            "- व्यक्तिगत जानकारी: हम आपकी पहचान करने वाली कोई भी व्यक्तिगत जानकारी जैसे आपका नाम, ईमेल पता या फोन नंबर एकत्रित नहीं करते हैं।",
            "- उपयोग डेटा: हम यह जानकारी एकत्रित कर सकते हैं कि आप ऐप का कैसे उपयोग करते हैं, जिसमें आपके डिवाइस का आईपी पता और उपयोग पैटर्न शामिल है।",
            "- मीडिया फ़ाइलें: ऐप आपको व्हाट्सएप से स्टेटस अपडेट डाउनलोड करने और सहेजने की अनुमति देता है, लेकिन हम अपने सर्वरों पर कोई मीडिया फ़ाइलें संग्रहित नहीं करते हैं।",
            "2. हम आपकी जानकारी का उपयोग कैसे करते हैं:",
            "- ऐप प्रदान करने और बनाए रखने के लिए: हम आपके उपयोग डेटा का उपयोग ऐप की कार्यक्षमता बनाए रखने और सुधारने के लिए करते हैं।",
            "- उपयोग की निगरानी करने के लिए: हम उपयोग डेटा का उपयोग उपयोगकर्ता अनुभव को बढ़ाने और समस्याओं को शीघ्र हल करने के लिए करते हैं।",
            "- आपसे संवाद करने के लिए: हम आपको ऐप से संबंधित अपडेट भेज सकते हैं, लेकिन हम इसके लिए व्यक्तिगत जानकारी एकत्रित नहीं करते हैं।",
            "3. हम आपकी जानकारी को कैसे साझा करते हैं:",
            "- आपकी सहमति से: हम आपकी जानकारी को तीसरे पक्ष के साथ साझा कर सकते हैं यदि आप स्पष्ट सहमति देते हैं।",
            "- कानूनी आवश्यकताएँ: हम आपकी जानकारी को तब प्रकट कर सकते हैं जब यह कानून द्वारा आवश्यक हो या सार्वजनिक प्राधिकरणों द्वारा वैध अनुरोधों का जवाब देने में।",
            "4. डेटा सुरक्षा:",
            "आपके डेटा की सुरक्षा हमारे लिए महत्वपूर्ण है। हम आपकी जानकारी को अनधिकृत पहुंच से सुरक्षा करने के लिए उचित सुरक्षा प्रक्रियाओं को लागू करते हैं।",
            "5. बच्चों की गोपनीयता:",
            "हमारा ऐप 13 वर्ष से कम उम्र के किसी भी व्यक्ति को लक्षित नहीं करता है। हम 13 वर्ष से कम उम्र के बच्चों से व्यक्तिगत पहचान योग्य जानकारी जानबूझकर एकत्रित नहीं करते हैं। यदि आप एक माता-पिता या अभिभावक हैं और आपको यह पता है कि आपके बच्चे ने हमें व्यक्तिगत डेटा प्रदान किया है, तो कृपया हमसे संपर्क करें।",
            "यदि आपको इस गोपनीयता नीति के बारे में कोई सवाल है, तो कृपया हमसे संपर्क करें: amannishad0512@gmail.com"
        ),

        "Gujarati" to listOf(
            "વ્હોટસએપ સ્ટેટસ સેવિંગ માટેની ગોપનીયતા નીતિ",
            "પ્રભાવિત તારીખ: 8 ઓક્ટોબર, 2024",
            "WhatSaveKaro (\"સ્ટેટસ સેવિંગ\")માં આપનું સ્વાગત છે. આપની ગોપનીયતા અમારે માટે મહત્વપૂર્ણ છે. આ ગોપનીયતા નીતિ એ સમજાવે છે કે જ્યારે તમે આપણા એપ્લિકેશનનો ઉપયોગ કરો છો, ત્યારે અમે તમારી વ્યક્તિગત માહિતી કેવી રીતે એકત્રિત, ઉપયોગ અને સુરક્ષિત કરીએ છીએ.",
            "1. અમે કઈ માહિતી એકત્રિત કરીએ છીએ:",
            "- વ્યક્તિગત માહિતી: અમે તમારી ઓળખ કરી શકે તેવી કોઈપણ વ્યક્તિગત માહિતી, જેમ કે તમારું નામ, ઈમેલ સરનામું અથવા ફોન નંબર, એકત્રિત નથી કરતા.",
            "- ઉપયોગ ડેટા: અમે માહિતી એકત્રિત કરી શકીએ છીએ કે તમે એપ્લિકેશનનો કેવી રીતે ઉપયોગ કરો છો, જેમાં તમારા ઉપકરણનો IP સરનામું અને ઉપયોગ પેટર્નનો સમાવેશ થાય છે.",
            "- મીડિયા ફાઈલો: એપ્લિકેશન તમને વ્હોટસએપમાંથી સ્ટેટસ અપડેટ ડાઉનલોડ અને સેવ કરવાની મંજૂરી આપે છે, પરંતુ અમે અમારા સર્વર પર કોઈપણ મીડિયા ફાઈલ્સ એકત્રિત અથવા સ્ટોર નથી કરતા.",
            "2. અમે તમારી માહિતી કેવી રીતે ઉપયોગ કરીએ છીએ:",
            "- એપ્લિકેશન પ્રદાન અને જાળવવા માટે: અમે તમારા ઉપયોગ ડેટાનું ઉપયોગ કરી આપના એપ્લિકેશનની કાર્યક્ષમતા જાળવવા અને સુધારવા માટે.",
            "- ઉપયોગ પર મોનીટરીંગ માટે: અમે ઉપયોગ ડેટાનું ઉપયોગ કરીને વપરાશકર્તા અનુભવને વધારવા અને સમસ્યાઓને તરત જ હલ કરવા માટે.",
            "- તમારા સાથે સંપર્ક કરવા માટે: અમે એપ્લિકેશન સાથે સંબંધિત અપડેટ્સ મોકલી શકીએ છીએ, પરંતુ આ માટે વ્યક્તિગત માહિતી એકત્રિત નથી કરતા.",
            "3. અમે તમારી માહિતી કેવી રીતે શેર કરીએ છીએ:",
            "- તમારી સંમતિથી: અમે તમારી સંમતિ આપેલા ખંડમાં તૃતીય પક્ષ સાથે તમારી માહિતી શેર કરી શકીએ છીએ.",
            "- કાનૂની આવશ્યકતાઓ: અમે તમારી માહિતી કાયદા દ્વારા જરૂરિયાત મુજબ અથવા જાહેર સત્તાવાળાઓના માન્ય વિનંતી પર પ્રકટ કરી શકીએ છીએ.",
            "4. ડેટા સુરક્ષા:",
            "તમારા ડેટાની સુરક્ષા અમારે માટે મહત્વપૂર્ણ છે. અમે તમારી માહિતી અનધિકૃત પ્રવેશથી સુરક્ષિત રાખવા માટે યોગ્ય સુરક્ષા પ્રોસેસીસ લાગુ કરીએ છીએ.",
            "5. બાળકોની ગોપનીયતા:",
            "અમારું એપ્લિકેશન 13 વર્ષથી નીચેના કોઈપણ વ્યક્તિ માટે નિર્દેશિત નથી. અમે 13 વર્ષની વયથી નાના બાળકોની વ્યક્તિગત ઓળખ ઓળખી શકાતી માહિતી જાણબૂઝને એકત્રિત નથી કરતા. જો તમે માતા-પિતા અથવા કાળજી લેવા વાળા છો અને તમને ખબર છે કે તમારા બાળકએ અમને વ્યક્તિગત માહિતી આપી છે, તો કૃપા કરીને અમારો સંપર્ક કરો.",
            "આ ગોપનીયતા નીતિ વિશે કોઈ પ્રશ્નો હોય તો, કૃપા કરીને અમારો સંપર્ક કરો: amannishad0512@gmail.com"
        ),

        "Bhojpuri" to listOf(
            "व्हाट्सएप स्टेटस सेवेर खातिर गोपनीयता नीति",
            "प्रभावी तिथि: 8 अक्टूबर, 2024",
            "व्हाटसेवकारो (\"स्टेटस सेवेर\") में आपका स्वागत बा। आपके गोपनीयता हमरा खातिर बहुत ज़रूरी बा। ई गोपनीयता नीति समझावेला कि हम रउआ व्यक्तिगत जानकारी कइसे इकट्ठा, इस्तेमाल, आ सुरक्षित रखल जाला जब रउआ हमरा ऐप के इस्तेमाल करत बानी।",
            "1. हम का जानकारी इकट्ठा करिला:",
            "- व्यक्तिगत जानकारी: हम रउआ के पहचान सके वाली कौनो व्यक्तिगत जानकारी, जइसे रउआ के नाम, ईमेल पता, या फोन नंबर, इकट्ठा नइखी करत।",
            "- उपयोग डेटा: हम जानकारी इकट्ठा कर सकेनी कि रउआ ऐप के कइसे इस्तेमाल करत बानी, जइमें रउआ के डिवाइस के आईपी पता आ उपयोग के पैटर्न सामिल बा।",
            "- मीडिया फाइल्स: ऐप रउआ के व्हाट्सएप से स्टेटस अपडेट डाउनलोड करे आ सेव करे के अनुमति देला, बाकि हम अपने सर्वर पर कौनो मीडिया फाइल्स इकट्ठा या स्टोर नइखी करत।",
            "2. हम रउआ के जानकारी कइसे इस्तेमाल करिला:",
            "- ऐप के प्रदान आ बनाए रखे खातिर: हम रउआ के उपयोग डेटा के इस्तेमाल करतानी ऐप के कार्यक्षमता के बनाए रखे आ सुधार करे खातिर।",
            "- उपयोग पर नजर रखे खातिर: हम उपयोग डेटा के इस्तेमाल करतानी ताकि उपयोगकर्ता के अनुभव बेहतर हो सके आ समस्या के जल्दी समाधान मिल सके।",
            "- रउआ से संपर्क करे खातिर: हम रउआ के ऐप से संबंधित अपडेट भेज सकेनी, बाकि हम एह खातिर व्यक्तिगत जानकारी इकट्ठा नइखी करत।",
            "3. हम रउआ के जानकारी कइसे साझा करिला:",
            "- रउआ के सहमति से: हम रउआ के जानकारी तीसरे पक्ष से साझा कर सकेनी अगर रउआ साफ सहमति देले बानी।",
            "- कानूनी आवश्यकता: हम रउआ के जानकारी तब दिखा सकेनी जब कानून के मांग होखो या सार्वजनिक प्राधिकरण से वैध अनुरोध होखे।",
            "4. डेटा सुरक्षा:",
            "रउआ के डेटा के सुरक्षा हमरा खातिर बहुत महत्वपूर्ण बा। हम रउआ के जानकारी के अनधिकृत पहुँच से बचावे खातिर उचित सुरक्षा प्रक्रिया लागू करिला।",
            "5. बच्चों के गोपनीयता:",
            "हमरा ऐप के लक्ष्य 13 साल से कम उम्र के कउनो व्यक्ति नाहीं बा। हम 13 साल से कम उम्र के बच्चों से व्यक्तिगत जानकारी जानबूझ के इकट्ठा नइखी करत। अगर रउआ एक माता-पिता या अभिभावक बानी आ रउआ जानत बानी कि रउआ के बच्चा हमरा से व्यक्तिगत जानकारी देले बा, त कृपया हमसे संपर्क करीं।",
            "अगर रउआ के एह गोपनीयता नीति के बारे में कउनो सवाल बा, त कृपया हमसे संपर्क करीं: amannishad0512@gmail.com"
        )
    )

    val selectedPolicy = privacyPolicies[selectedLang] ?: privacyPolicies["English"]!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(verticalScroll)
            .padding(16.dp)
    ) {
        for (i in selectedPolicy.indices) {
            when (selectedPolicy[i].take(2)) {
                "1." -> ExpandableSection(
                    title = selectedPolicy[i],
                    content = selectedPolicy.subList(i + 1, selectedPolicy.indexOfFirst { it.contains("2.") })
                )
                "2." -> ExpandableSection(
                    title = selectedPolicy[i],
                    content = selectedPolicy.subList(i + 1, selectedPolicy.indexOfFirst { it.contains("3.") })
                )
                "3." -> ExpandableSection(
                    title = selectedPolicy[i],
                    content = selectedPolicy.subList(i + 1, selectedPolicy.indexOfFirst { it.contains("4.") })
                )
                "4." -> ExpandableSection(
                    title = selectedPolicy[i],
                    content = selectedPolicy.subList(i + 1, selectedPolicy.indexOfFirst { it.contains("5.") })
                )
                "5." -> ExpandableSection(
                    title = selectedPolicy[i],
                    content = selectedPolicy.subList(i + 1, selectedPolicy.size)
                )
            }
        }
    }
}



@Composable
fun ExpandableSection(title: String,  content:List<String>, initiallyExpanded: Boolean = false) {

    var isExpanded by remember {    mutableStateOf(initiallyExpanded) }
    Column(modifier = Modifier.padding(vertical = 8.dp)){
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .clickable {
                    isExpanded = !isExpanded
                }
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.primary.copy(0.1f),
                    shape = MaterialTheme.shapes.small)
        )

        if(isExpanded){
            for(item in content){
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp, bottom = 4.dp)
                )
            }
        }
    }
}