/* Adam Morris
     November 18, 2014
     Purpose: This class creates two files, one binary for character values and
               one binary for holding an object file. The program then reads in
               the characters of three specified files and displays their ascii
               equivalents
     Inputs: Strings for determining input files and output files
     Output: creates two binary files and outputs data to the screen
*/
package cecs277lab20streambinaryio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class CECS277Lab20StreamBinaryIO {
    // Inner class for creating an object
    public static class Student implements Serializable{
        String mName = "";
        String mMajor = "";
        Double mGPA = 0.0;
        
        //default constructor
        public Student(){
            mName = "Default";
            mMajor = "UnDeclared";
            mGPA = 0.0;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanner input for taking in file names
        Scanner in = new Scanner(System.in);
        try
        {  
            //Write output file name
            System.out.print("Output Binary file: ");
            String outFile = in.next();

            //Create outputstream object
            OutputStream outStream = new FileOutputStream(outFile);
   
            //Write all characters from 32 to 126 to file
            for(int i = 32; i <= 126; i++)
                outStream.write(i);
            
            //Close the file
            outStream.close();
            
            //Specify object file name
            System.out.print("Output Object file: ");
            String outObjectFile = in.next();

            //Create object output stream object
            ObjectOutputStream outObjectStream = new ObjectOutputStream(new 
             FileOutputStream(outObjectFile));
   
            //Create new object
            Student s = new Student();
   
            //Write object to file
            outObjectStream.writeObject(s);
            
            //Close the output object stream
            outObjectStream.close();
            
            //Read in Three files
            for (int i = 0; i < 3; i++) {
                System.out.print("\n\nInput file: ");
                String inFile = in.next();
                InputStream inStream = new FileInputStream(inFile);
                
                //Read in one byte of data
                int data = inStream.read();
                int count = 1;
                //run if data is present
                while(data != -1){
                    count++;

                    //if 64 characters are printed, then print a return
                    if (count % 64 == 0)
                        System.out.println("");

                    //Print out the data
                    System.out.print((char)data);
                    //Take in another byte
                    data = inStream.read();
                }
                //Close the input stream
                inStream.close();
            
            }
        }
        catch (IOException exception)
        {  
           System.out.println("Error processing file: " + exception);
        }
        finally{
            System.exit(0);
        }
    }
}
/*
run:
Output Binary file: binary9.bin
Output Object file: object9.bin


Input file: binary9.bin
 !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]
^_`abcdefghijklmnopqrstuvwxyz{|}~

Input file: object9.bin
¬í sr =cecs277lab20streambinaryio.CECS277Lab20StreamBinaryIO$
Student©JºÙÅ]Ü L mGPAt Ljava/lang/Double;L mMajort Ljava/
lang/String;L mNameq ~ xpsr java.lang.Double³ÂJ)kû D val
uexr java.lang.Number¬à  xp        t 
UnDeclaredt Defau
lt

Input file: word.docx
PK    ! ß¤ÒlZ     [Content_Types].xml ¢(       
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                           ´ËnÂ
0E÷ú·Ubè¢ª*>-Ré{VýÇ¼þ¾QU
l"%3÷Þ3VÆÑÚl	µw%ë=
^i7+Ù×ä-d&á0ÞAÉ6l4¼½L60#µÃÍS
O£Xø *V$z3ü3à÷½Þ
Þ%p)Oµ^ ²×5}nH"dÙsÓXgL`´ê|éÔ|PrÛsð?PWìt
t4Q+ÈÆ"¦wa©¯|T\y¹°¤,NÛàôU¥%´úÚ-D/ÎÜ¢­X¡Ýÿ(¦¼<EãÛ)à
 ;çNL?¯FñË¼¤¢Ü¸<FkÝ	h¡yöÏæØÚ¤Îqôi£ã?ÆÞ¯l­Îià 1éÓ]HÖ
gÏõm @ÈæÛûmø  ÿÿ PK    ! ·ï   N  _rels/.rels ¢
(                                                            
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
      ¬ÁjÃ0@ïýÑ½QÚÁ£N/cÐÛÙ[ILÛØj×þý<ØØ]éaGËÒÓÐzsFuà
½	Öù^Ã[û¼x ¼¥1xÖpâæöfýÊ#I)ÊYÏøÍÀå*Döå§i")Ï
Ôc$³£qU×÷~3 1ÕÖjH[{ª=E¾ºÎ~
f?±3-ÂÞ²]ÄTê¸2j)õ,l0/%
b¬
ð¼Ñêz£¿§Å,	¡	/û|f\Zþçæ?6ï!Y´_áo]Aó  ÿÿ PK   
 ! Öd³Qô   1  word/_rels/document.xml.rels ¢(           
                                                                
                                                                
                                                                
                                                       ¬ËjÃ0E÷
þ}-;}PBälJ!ÛÖý E?¨,	Íôá¿¯HIëÐ`ºðr®sÏ6ÛÏÁwÔ{§ Èrè¯{×*x©
¯îAkWkë*`[^^lÐjNKÔõD¢8RÐ1µd:4e> K/æ4ÆVm^urçw2NP
0Å®Vwõ5jø¶oÞà7o:>S!?pÿÌé8JX[d0KDçEVKÐc2§P,ªÀ£Å©À
a«¿]²Ó.þ¶Æï°s¸YÒ¡ñ+½·è(!O>zù  ÿÿ PK    ! Ö"> 
 t     word/document.xml¤Umk1þ>Ø0þÞÜËÒ&M
m²RØ ,Ýçáø|w&gËØN
²ì×O¾\öBIgË=låöî§ªÉNX'AÏh2)C.u9£ß_>_M)qéÕ Å£wón÷
Y|«ö!´ËöÏhå½É¢ÈñJ(æFJr
?â "(
ÉE´GiÄÍÎXàÂ9÷Àô9ÚÁ©Ñ
Ê¬bE[FÙÍÖ\!ºa^®e-ý±ãftkuÖA\	¬%Ô-½='në²è*ÐD¬¨hWI3¤ñ
^4TV=Èîµ$vªîíö&_Öe{\Àsèç­ª[æ¯#&ñ	Gs(ü³g¢ÔCàwæ¤¸ÉõÛ Ò
¿LyYs-lÍ&/C{Ò#VxÙoÀê|»Ìªb_ âÙS©Á²u°e«NÂµ¦s8kÈa5dá
ÄÊ¿Íh§Óä>Ni´ÛÖ>hî7qçiÃÇÏ_*þñÂyr`xÈÃòaN&ä[4ÝFÁ!|ß5
À&gÖc,cT3T<Â=ãÚ.u~´(ÔNpÿlÿBZ¹ú*¼ôIî¯§ã#|
eÁÙ¾ÍdÜXYV~×à=¨A®Eq¢­ËN¹IÚ?Ë­oÄ.Úá©3Ö¦9ÆÊ=ZÒ«¥ÏÒs
dùé¦Ï³M±Ù¶=¿ùo   ÿÿ PK    ! ªR%ß#       word/theme
/theme1.xmlìYM7¾úÄÜÍøc7Øc;i³ì&%GyFQ¬IÞ]%9
¥ié¡Þ
z(m	ôþmSÚòªÑxlÉYÚl`)YÃZÏûêÑûJ4ËWNã¦§z©â 4ÄiÔqî
K-pÓ¢3GÜ¹²ûááQ´Oùì8±Ór²òKtRÙ7¦,BVYT<~R®
U*rqê&ÒíÍñf.ÝÂùÈ©àYC@ØAæ
NªÙs0pIÇãôøÈ
ìè8õçw/FDl±Õìêoa·'5eÇ¢ÑÒÐu=·Ñ]úW "6qæ 1h,ý) 9Óõzí^ß
[`5P^´øî7ûõª×ü×7ð]/ûxÊî~8ôW1Ô@yÑ³Ä¤Yó]¯@y±±oVº}·ià(&8l 
+^£î³]BÆ\³ÂÛ;lÖðª¬­®Ü>ÛÖZïS6 \(p
Ä|Æ08<bìá(o
SÊe
s¥VVêòöqUIEî ¨YçMßhÊø 0<çcéÕÑ o^þøæåspúèÅé£_N?>}ô³ÅêL#Ý
êõ÷_üýôSð×óï^?ùÊç:þ÷>ûí×/í@¡_}ýìÏ^}óù?<±À»tø!N7Ð1¸M91
Ë hÄþÅa±nÑM#SÙXÐèsH ×Cfï2)6àÕÙ}ðAÌf[×ãÄ îSJzYçt=
áml-¿ÙT®wlséÇÈ yÈ¥H¬N²ÝÃØë>åt,À=z[Cr
GÆjZ]ÃÌËÜFPæÛÍþ]Ð£Äæ¾L¤ÜØ\"bñ*	XÃèÈ=(bÉ9s!3!B
¹)Õ}:ñcL­qëØøD.nQa%AÍÕe`º5Ýw
12Ò}öÞ¾#Õ¾@²³m	DÍý8'cóò'8=SÜ×dÝ{·².ôÕ·Oíº{!½Ë°uG­Ëø6Üºx
ûøâkwÎÒ[Hnô½t¿îÿ½toÛÏç/Ø+Vøâª®Ü$[ïícLÈ´Çºs9½p(UE-
¦±,.3pª`Äp*©ª"¾pq0¥\ªÙê;ë ³dykµZ<J(Víò|)Úåi$ò
ÖFs¶t¯jzTd¶ÿ6I¢n!Ñ,Ï ¡fv.,Ú­ÌýVêk¹ÿ Ì~ÔðÜ\o 0ËS
zY(6i4[ï"×¬iIÍ8{®îI
7v±¼Êb2þx¦DiÇ	Ä"ÐÿEY¦>äqS]ùü,'r­ëi é[µÖÌæxAÉµ+/r
êKO2Q ¶´¬ª²/wbí}KpV¡3Iú ÁÌØm(å5«Y CÌÅ2!fÚâ^EqM®[ÑøÅlµE!
Æpq¢èbÃUyIGbº>+³¾Ì(ÊôÖ§îÙFY&[ìÔ´ëÇ»;ä5V+Ý7XåÒ½®uíBë¶o
 hÔVÔ2Æj«VÚ9´áKsÛqÞ§ÁúªÍâ^©j¯&èè¾\ù}y]ÁUt"üâGå\
	Tk¡.'Ìî8*^×õk_ª´¼AÉ­»RËëÖK]Ï«W^µÒïÕÊ 8©zùØCù<Cæ7/ª}ãíK
R\³/4)Su.+cõö¥ZÛþö`Ú°]o÷¥v½;,¹ý^«Ôö½R¿á7ûÃ¾ïµÚÃ8R`·[÷
ÝÆ UjT}¿ä6*ýV»Ôtkµ®Ûì¶n÷á"ÖræÅw^Åk÷   ÿÿ PK    ! U>Ëí
«  ­	     word/settings.xml´VÛnÛ8}_`ÿAÐó*ÛI:EmÇÛñvQ¹@M
7·Øß!%FNZÞ-údrÎÜ8sfä7o8öD*Å,Î.Ò8"¢í,þ¼Y%×qd,1)È,>
¿½ýý·7ÂkAÍDàB×³xg­*F#SGæB*" l¤æÈÂUoGéÇV%µä
YZQFíq§é4îÝÈ
YÜjQô.Nk-l¬3)dÓÐô?ÁB·3YÊºåDXq¤	¤0;ªLðÆÿ¯7 wÁÉþGØsôYzÆ
â,$HÅxü£çØ»¢wæYêO§OþüÃÎyI=ÐJ#Ýñ¤¯
û­UX	Ï £øhùEJ
½NgÓxä ¨lJ,Ø(Â'yb«z·Á¤A-³
Äá%/c-1qµ_l
gà£C=NB¾$aè5Ådã*XÚ##+H¾¤_È;?´ÆRðèÇã'2øQD¸È¡ç£"+leúEÁ|'Vª
5ÕZê{¿,m¢! ®­>TË¯ó{0ìÚ;:¥lnlÂá6¨¦éünfã.SH~ÍÓü{
È`3zöÍ·ÛþÖáäñÎbx¥)ÖnûF¥çT¼"0Îä)Û*IÒ#ÆV0IðãÅLZÆ
Ùéíà·×ÐßÂÔ~xöå¶ ÑjÙª=h¤:l<î-©°¹i«2X	X@'P+ðÇ½öuÊs(,4Ò
ÒòðºD$Ë0L®Ùdê8Sm³YÌèvg3×f7I©¶yåË;Ì_Pí^ÚýaåAv¢wd
ldãA6	²É ÙÔÉv0­Vç#Ð7¼ÉÁïüQW³C,»Í
ô _µ&Úä	ö6ÁÔÂ
E1GOÐ£4÷{¼×fè([ûB×aNY½ôEap^{¿ÊÅmüË#¯E~Ñ%Î¨aW°ó­ÔûÃcÙÄ
ìXýD92÷õ=v¨ÎæëäÝäjgY²®nñÍÝur³¸Ëår^.&««,¿ü§Âð?ëö
_   ÿÿ PK    ! Ë?Ä  í     word/fontTable.xml¼ÛÛ0
ï}¡ûe'ÙYgÙ¦(^í(lê`4JÜ¼}G²ã¶¥	Ê äf>~æñéÑä =(g+Ï%
Ò
·S¶©è·×ÍÍ=%¸Ýqí¬¬èQ}Z½÷Øµ³Ö[(¨hBWfV3×IÁÚyÃþú&3Ü
ßw7ÂµUZcV0vKG¿âêZ	ùÑ½6¤úÌKDg¡Uhý%´Þù]ç øf£áÊN|q
2Jx®3|ÌØQBayÎÒÉè_åubQ~j¬ó|«Ñ|ì ®F÷I_Zn0°æZm½J[2ÇØë²
mØ÷ø-Ø<î4¢ådlkn>TèÀèTíI?p¯bST=lYE_®b³¡WtÂó
zRxWZù¨Ì'EE$ÎñªDâL9xg68pæÄ«2ÈÙ¯Îpû#»E'èGtf~#>q¯u¤xùÝ
5*w÷ù#wdà\îÈ8ä³jÚðæÄ¹ø_ò[FCþÝ}8ó#½þ'd<Àê'   ÿÿ PK
    ! [mý	  ñ     word/webSettings.xmlÑÁJ1à»à;,¹·Ù
X¥Öµ© yZ´jÍËó|pm*).-]
¤­ÙÙôülÒ7=, ý)*Iô­YkÅ¯)CÒÇ]ÑW¿nòÀfWÂ"ÄP¶v\×Wf
Ïð)
u]ðpK~Ê®ß2D)É:dùÑúS´x<è>¿=t!ÑÅÁ3	ue¨Ëì'ÚQÚ>ªw'¿
Àåÿñ@ßÜ¯±[D@'©3SÍr	>`N|ÃÔ°ýºv1Rÿøp§ýÔô  ÿÿ PK 
   ! ´¹NUÑ  Ó  docProps/app.xml ¢(                     
                                                                
                                                                
                                                                
                                             SÁnÛ0½Ø?º7rÒ®(
EÅbèa[ÄmÏLÇÂdIX£Ù×¶WÙvOïÔÓIÛ×Î=Äd¼Û°å¢d8íkãöX}¹¸aE
;Bb·òã±>@D© 	6¬EkÎn¡SiAiGÆÇN!Ñxà¾i;¯_:pÈWeyÍáÁÕ
P_YMëÿW´özðªc =)*èòûpÒ
>DåQÙÊt WØ©$¹|âÙÇ:ÉkÁ' ¶­
J#µN^Qñ9k´Bê©üftôÉ7X<Fá¸ày ó{Ð/ÑàQçT|5n²1²Õ!ªÐ¾yØk
eaKÏ²	{PÃHwÊþz\÷ ÑÇ"_4Ô+~¨C³6¬WÑ(l*ÈmHeeÐöÌGåØ\
¶û
  ÿÿ PK
    !  B#o  í  docProps/core.xml ¢(             
                                                                
                                                                
                                                                
                                                     ÉnÂ0ïú
ïãPuBPq*R¥RµêÍµpÙÀÛ×I 4*Þfùæ÷ø·ÉNVÑ¬ZIRbµ£·ù
X/ÀEAI¹1Zyor[¤.	
Í¶úÚ%6­ép
¦×X§zÁØôè ÉY/i6¶j8ÃPå&	Á'Öîì@ÛùEJá÷Î¢ÇfOïèÁº®zÔ¢a
?fÏ¯íUc¡¯ ²à,÷ÂWPøÈm¾¾ù®Ü'!f¨×¶¼çTF3m­p-s¬7¯a_kË]dãà
Æwì´@WÔùYxØ þ°ó·ÝLXØæ_¤%ú´8Ü­<
æäÇÎûèñi>Ee«ÜÎ
AÃZþ   ÿÿ PK    ! Fj  p   
  word/styles.xml¼]sÛºï;ÓÿÀÑU{Èògâ9ÎÛkOãÈi®!²PÊØî¯/ 
Rä%(.¸õ-Qû Ä»/åôÛïÏ©~ñ¼*;MÞï"Å*ÙÃÙèÇýÕ»£¨(Y0©2~6záÅè
÷OýËoO§Eù"yi@V¦ñÙhQËÓñ¸<eÅ{µäÞ8WyÊJý2§,¬ïb.Y)fBòe¼¿
·w<j0yÏEÌ?«¸JyVÚøqÎ¥&ª¬Xe±¢=õ¡=©<Yæ*æE¡w:5/e"[c& 8Wïõ
Î4=²(>Ù³ÿ¥r8Âö×4>½yÈTÎfR¾îI¤a£OzøæsVÉ²0/ó»¼yÙ¼²®TVÑÓ)+
b!îuË
Í»>Ï
1Ò[8+ÊóB°ÖóOë¸(·/D"FcÓbñ_½ñg£ýýÕ;¦[ïI=¬ÞãÙ
»S·'Î[3Í=±üÝôÜ«ÿ:»»|ýÊ6¼d±°í°yÉufM÷T
ÈûGW/¾WflYUª¦¨ÿ
®±c0â:átúMkè­|þUÅ<zÃÙÈ¶¥ßüqsëL?}´mê7§<×"Ixæ|0[ÿ\ðìGÁ
Íû^ÙlmÞUéÿN&6d|yùÒä¾Þ1£É7 Í§+±iÜÿg4J´Å/83@4y°ÝG!öM
Dáìm;³zµïöS¨Þª¡Ã·jèè­:~«NÞª¡oÕÅü?YÂk#Âf uÇãF4Çc64Çã%4Ç
c4Çã4Çèh'ÑO"8¥}Yè$û'Û»¹»aÜÝ0îî#@w÷ÆÝ=¿qwOçaÜÝ³w
w÷dçÖK­èFÛ,+»l®T©G%NcfÙªgz<'ÙIL=³5âÁ´Ù×»3Ä4üx^B.
Róh.ª\ÓC;Î³_\ê²6bI¢yÀUîÎùç<9ebÓAM%eU:#ÈÍ%{ cñ,!¾d
RX'´®Æ$ ©Sçjx×#¾bøXHtQIÉXßhRÌ²×3¼4°áÅ/Í¨¨¡
mø¸ÝRÚ)Þ]uLú»»ÊÇÜ©xÈ^ ?Ü4çL£;³
-9+Ýu÷ÛÎJ^¢{cÚDµ®·)r©÷ZdÕðÝ¢QkÍ#²×Gd°5o¸Ånõ2Ù,Ð®iêi5+
[MkI½L;e²ª´ÃÝÆÊá¶1ÀÈ2´c	2øYÎ9)f¾M/wlÃn«×³i÷$A/¥i¦áë
%ÏuYö8t¥¤TO<¡#NË\Õ¹æZ~ßJÒËò_ÒåÂÖJ[þúÕðè-ïÐd"£ÑíË»	Ñ­
 ®ïo¿F÷jiÊL304ÀU*%c6gÿöÏþNÓÁs]g/D{{NtzÈÂ.ÁA¦&©¤"$ÇPËû
YÞ¿X.Ìy!*SÝÀÓE5û7OußTDrfè
à

H6+ Ù*Y¥YA¹ÇG¸ÃG½¿)cy§ä,ï¹HÈÄ°0*%,J£ÒÀÂH~~~
#Z80ª<#=ü]åq`TyfaTyfaTyfaTyvð9âó¹^Ób$UÎ9HºMVòt©r¿!¿Hþ
NÖ´»\ÍÍ*«oâ&@sÔp±]ã¨DþÉgd]3,Ê~eR*EtnmsÀ±Û÷®í
³OrîÂd
1_(ðÜ³OþX]/OëÇ2^wßv£×iÏ¯âaQFÓÅúl¿9ÞÛ¹*Ø·Âv7Ø6æÇ«çYÚÂny"ªtÕQø0
ÅñAÿ`Ñ[Á»7+­È£°ÍãÝUòVäIÏHØæÖ§[]~øÌòÇÖD8éÊuçI¾®,Z
·6ÛHëÈ¶<éÊ¢-«Dçql®@uúyÆßÏ<þxüüÞ¾ò#ºöÿæÈ4m{ë»'À¼o
Ñ½fÎ?+U·ßºàÔÿ¡®½pÊ
µrú_¸ÚeüãØ{ºñ#zÏ;~Dï	Èè5yÃQSÒ{nò#zOR
~z¶GÜlãq³­ %d¶°
ð#z/´Q!mÔ+?eTdTHA"ÐF´Qág
\Û{Ã
)h£BÚ¨6ª]/0*ÇÆR
B
)h£BÚ¨6*D 
h£BÊ¨ <È¨6*D 
h£ÖÆã
ãC
)!F´Q!m
T@"ÐF´Q!eTdTHA"ÐF´QíÅÂFñ8£Âø£BJQ!mT@"ÐF´Q!
mT@RÐF´Q!¢+?K¾Ûì'ø³Þ;öû_ºj:õÝ}ÛEôG­zågõáB©Ç¨õÁÃ
[oôÊ¢ö\Vw¹öÔÏ?.»ðqé¿t©yÂ^3ðÃ¾àÊaWÊ» È;ìÊt7¬:»f
_7»&]ëËÕM)úp»¦'xâ	ï­p8Ä]s´G¸kfvá wÍÇNàQd&ç×ÑG=Çéx})
0áRCT°
QaRÃÅVjHÀ
	X©!!Hj	¢¥¨0©A°RCVj`Â¥¨`©!ªKj{eKjÂN8næâÈN
 nrvª%':°ZÕÔj¥9®ZrEóúªç'ôÑO@ééÅàõ£Ð
ûQaRãª¥6©Ãê'`¥ÆUK^
©qÕR§Ô¸j©Sj\µäW-µI«Ú¤ý ©qÕR§Ô¸j©Sj\µäW-µI«Ú¤ÆUKmR< 
{1áRãª¥N©qÕ_j\µÔ&5®ZjW-µI«¼Rãª¥N©qÕR§Ô¸jÉ/5®ZjW-µI«Ú¤ÆU
K^©qÕR§Ô¸j©SjOµ4~Úú&Ã¶?H¦?\¾,¹ùnç¤þÒæ" ýàM²þ¡$lz5?IÕ¼m;Ü\
0¬[´°©x¡ÛoOò4Õ|êú1û¨¯ö|UªíÈVnts)´þÜÖeÏÎ~fÈ;úl%é£Z5_
?6i¸«º?3Yÿhþç&K4à©ùÁªº§É3«Qzû%òÕVKÿG%õÖÉ}hþÕöYýýoÞøÜN^
-Ãmo§:Ò¾­þ+>ý  ÿÿ PK-     ! ß¤Òl
Z                      [Content_Types].xmlPK-     ! 
·ï   N                 _rels/.relsPK-     ! Öd³Qô   1
               ³  word/_rels/document.xml.relsPK-     ! 
Ö">  t                 word/document.xmlPK-     ! ª
R%ß#                 V  word/theme/theme1.xmlPK-     
! U>Ëí«  ­	               ¬  word/settings.xmlPK-     !
 Ë?Ä  í                 word/fontTable.xmlPK-     !
 [mý	  ñ               z  word/webSettings.xmlPK-    
 ! ´¹NUÑ  Ó               µ  docProps/app.xmlPK-     !
  B#o  í               ¼  docProps/core.xmlPK-     ! 
Fj  p               b  word/styles.xmlPK      Á  ª) 
   BUILD SUCCESSFUL (total time: 25 seconds)

*/