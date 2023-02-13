package com.example.practicehelper

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicehelper.databinding.ActivityGlossaryBinding
import kotlinx.android.synthetic.main.activity_glossary.*

class GlossaryActivity : AppCompatActivity() {
    lateinit var binding: ActivityGlossaryBinding
    lateinit var prefDefinitions: SharedPreferences
    lateinit var prefContent: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlossaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefDefinitions = getSharedPreferences("DEFINITIONS", MODE_PRIVATE)
        prefContent = getSharedPreferences("CONTENT", MODE_PRIVATE)
        addDefinition()
        addContent()
        createList()
    }
    fun addContent(){
        val editor = prefContent.edit()
        var definition = prefDefinitions.getString("definition1","")
        editor.putString("$definition","Судовые воздушные компрессоры необходимы для обеспечения потребителей судовой энергетической установки и судна в целом сжатым воздухом разного давления и расхода. \n" +
                "На судне потребителями сжатого воздуха являются: \n" +
                "- главный двигатель и дизельгенераторы (пусковой воздух); \n" +
                "- ДАУ главного двигателя; \n" +
                "- система автоматического управления и контроля; \n" +
                "- масляные фильтры ГД (продувание); \n" +
                "- продувание кингстонов; \n" +
                "- отключение ТВНД на ходу; \n" +
                "- выпускные клапаны ГД; \n" +
                "- зарядка аквалангов")
        definition = prefDefinitions.getString("definition2","")
        editor.putString("$definition","Замкнутая система судовых ДЭУ применяется обычно для отвода теплоты от деталей двигателей, а проточная – для охлаждения рабочих сред в теплообменниках (масла, воздуха)")
        definition = prefDefinitions.getString("definition3","")
        editor.putString("$definition","Кларификаторы называются осветляющими сепараторами, в которых происходит отделение из нефтепродуктов более мелких твердых частиц и незначительного количества жидких тяжелых примесей.\n" +
                "В отличие от пурификатора барабан имеет только одно выпускное отверстие, предназначенное для отвода очищенного нефтепродукта. Топливо, прошедшее грубую очистку в пурификаторе, или неочищенное смазочное масло, не содержащее воды, как в пурификаторе, подводится через распределитель к нижней части барабана. Далее начинается процесс тонкой очистки, который в принципе аналогичен очистке в пурификаторе.")
        definition = prefDefinitions.getString("definition4","")
        editor.putString("$definition","Командоконтроллер – это командоаппарат ручного управления, предназначенный для частого переключения  контактов в цепях управления. \n" +
                "В зависимости от типа, командоконтроллеры имеют до 12 рабочих положение и до 12 цепей. Каждому рабочему положению соответствует определенный рабочий режим, например, «травить», «лево», «скоростной спуск», «выбирать», «право», «тяговый подъем» и т.п. Число цепей определяется схемой управления электропривода – чем больше функций выполняет схема, тем больше число цепей.")
        definition = prefDefinitions.getString("definition5","")
        editor.putString("$definition","Компрессор — основной и наиболее сложный агрегат паровой компрессорной холодильной машины. Он предназначен для постоянного отсасывания пара, образующегося в испарителе при кипении хладагента, сжатия и нагнетания его в конденсатор.")
        definition = prefDefinitions.getString("definition6","")
        editor.putString("$definition","Кондиционирование воздуха в автономной системе осуществляется отдельными кондиционерами, обслуживающими одно или несколько смежных помещений.")
        definition = prefDefinitions.getString("definition7","")
        editor.putString("$definition","Проточная система охлаждения забортной водой в ДЭУ используется для двигателей небольшой мощности, их редукторов, компрессоров сжатого воздуха, подшипников и для всех теплообменников.")
        definition = prefDefinitions.getString("definition8","")
        editor.putString("$definition","Пурификаторами называются очишающие сепараторы, в которых происходит отделение двух взаимно нерастворимых жидкостей различной плотности и загрязняющих твердых частиц.")
        definition = prefDefinitions.getString("definition9","")
        editor.putString("$definition","Системы охлаждения - предназначены для отвода теплоты от различных механизмов, устройств, приборов и рабочих сред в теплообменных аппаратах.\n" +
                "Рабочими охлаждающими средами с СЭУ является забортная и пресная вода, масло, топливо и воздух.")
        definition = prefDefinitions.getString("definition10","")
        editor.putString("$definition","Судно - это плавучее инженерное сооружение, предназначенное для перевозки грузов, пассажиров и выполнения других специальных задач.")
        definition = prefDefinitions.getString("definition11","")
        editor.putString("$definition","Устройство для напорного перемещения главным образом капельной жидкости в результате сообщения ей внешней энергии (потенциальной и кинетической) называется насосом. Их широко применяют на транспортном и техническом флоте. Насосы по назначению обслуживаемых ими систем разделяют на общесудовые (пожарные, балластные, осушительные и т. п.), насосы, относящиеся к энергетическим установкам (питательные, топливные, циркуляционные, конденсатные и др.) и грузовые (зачистные), предназначенные для откачивания жидкого груза.")
        definition = prefDefinitions.getString("definition12","")
        editor.putString("$definition","Судовые электрораспределительные устройства - это комплектные электротехниче¬ские устройства в виде щитов с аппаратами управления, защиты и сигнализации, предназначенные для приема и распределения электроэнергии между приемниками.\n" +
                "Судовые электрораспределительные устройства классифицируют по следующим  основным признакам:\n" +
                "а) по назначению (главный, аварийный, группововой, приемника, генераторный)\n" +
                "б) по месту раположения на судне (районный, отсечный)\n" +
                "в) по конструктивному исполнению (каркасные, блочные)\n" +
                "г) по степени защищенности от воздействия окружающей среды (защищенные (IР21), брызгозащищенные (IР23), водозащищенные (IР55))")
        definition = prefDefinitions.getString("definition13","")
        editor.putString("$definition","Холодильные компрессоры - предназначенные для работы в широком диапазоне давлений всасывания и нагнетания, считаются универсальными. Это компрессоры одноступенчатых холодильных машин. В судовых установках кондиционирования воздуха чаще всего применяются поршневые компрессоры, а иногда, при очень большой холодопроизводительности,— центробежные. Кроме того, в судовом холодильном оборудовании иногда используются ротационные, а в последнее время и винтовые компрессоры.")
        definition = prefDefinitions.getString("definition14","")
        editor.putString("$definition","Центральная система водяного охлаждения отличается тем, что она имеет только один теплообменник, охлаждаемый забортной водой. Остальные холодильники, включая холодильник пресной воды охлаждения цилиндров двигателя, охлаждаются от системы пресной воды низкой температуры.")
        definition = prefDefinitions.getString("definition15","")
        editor.putString("$definition","Электрические сети - предназначены для распределения и передачи электроэнергии и состоят из электрораспределительных щитов и линий электропередачи. Электрические сети подразделяют на силовые, аварийные и приемников.")

        editor.apply()
    }
    fun addDefinition(){
        val editor = prefDefinitions.edit()
        editor.putString("definition1","Воздушные компрессоры")
        editor.putString("definition2","Замкнутая система")
        editor.putString("definition3","Кларификатор")
        editor.putString("definition4","Командоконтроллер")
        editor.putString("definition5","Компрессор ")
        editor.putString("definition6","Кондиционирование воздуха")
        editor.putString("definition7","Проточная система охлаждения")
        editor.putString("definition8","Пурификатор")
        editor.putString("definition9","Системы охлаждения")
        editor.putString("definition10","Судно")
        editor.putString("definition11","Судовые насосы")
        editor.putString("definition12","Судовые электрораспределительные устройства")
        editor.putString("definition13","Холодильные компрессоры")
        editor.putString("definition14","Центральная система водяного охлаждения")
        editor.putString("definition15","Электрические сети")
        editor.putInt("numberOfDefinitions",15)
        editor.apply()
    }
    fun createList(){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        definitionsRV.layoutManager = linearLayoutManager
        val definitions = ArrayList<String>()
        val numberOfDefinitions = prefDefinitions.getInt("numberOfDefinitions",0)
        var countOfDefinitions = 1
        var definition = ""
        while (definitions.size < numberOfDefinitions){
            definition = prefDefinitions.getString("definition$countOfDefinitions","").toString()
            definitions.add(definition)
            countOfDefinitions++
        }
        val adapter = DefinitionsAdapter(definitions, object : DefinitionsOnClickListener{
            override fun onClicked(definition: String) {
                startDefinitionActivity(definition)
            }
        })
        definitionsRV.adapter = adapter
    }
    fun startDefinitionActivity(definition:String){
        val intent = Intent(this,DefinitionActivity::class.java)
        intent.putExtra("definition",definition)
        startActivity(intent)
    }
    fun btNavHomeOnClick(view: View){
        finish()
    }
    fun btNavDiaryOnClick(view: View){
        val intent = Intent(this,DiaryActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun btNavProfileOnClick(view: View){
        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}