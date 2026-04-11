package f9;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.r5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q4 implements c2 {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static volatile q4 f4347f0;
    public c A;
    public final a1 B;
    public a1 C;
    public v3 D;
    public h1 F;
    public final r1 G;
    public boolean I;
    public long J;
    public ArrayList K;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public FileLock R;
    public FileChannel S;
    public ArrayList T;
    public ArrayList U;
    public final HashMap W;
    public final HashMap X;
    public final HashMap Y;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public f3 f4348a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f4349b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public z3 f4350c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f4351d0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l1 f4353v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a1 f4354w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public n f4355x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c1 f4356y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g4 f4357z;
    public final AtomicBoolean H = new AtomicBoolean(false);
    public final LinkedList L = new LinkedList();
    public final HashMap Z = new HashMap();

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final p6.d f4352e0 = new p6.d(16, this);
    public long V = -1;
    public final n4 E = new n4(this);

    public q4(ad.b bVar) {
        this.G = r1.m(bVar.f415v, null, null);
        a1 a1Var = new a1(this, 2);
        a1Var.o1();
        this.B = a1Var;
        a1 a1Var2 = new a1(this, 0);
        a1Var2.o1();
        this.f4354w = a1Var2;
        l1 l1Var = new l1(this);
        l1Var.o1();
        this.f4353v = l1Var;
        this.W = new HashMap();
        this.X = new HashMap();
        this.Y = new HashMap();
        a0().v1(new androidx.fragment.app.m(this, bVar));
    }

    public static String I(String str, Map map) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    public static final boolean O(w4 w4Var) {
        return !TextUtils.isEmpty(w4Var.f4463w);
    }

    public static final void P(l4 l4Var) {
        if (l4Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (!l4Var.f4265y) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(l4Var.getClass())));
        }
    }

    public static final Boolean Q(w4 w4Var) {
        Boolean bool = w4Var.K;
        String str = w4Var.X;
        if (!TextUtils.isEmpty(str)) {
            int iOrdinal = ((d2) p6.d.C(str).f10037w).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return Boolean.TRUE;
            }
            if (iOrdinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    public static q4 x(Context context) {
        o8.u.g(context);
        o8.u.g(context.getApplicationContext());
        if (f4347f0 == null) {
            synchronized (q4.class) {
                try {
                    if (f4347f0 == null) {
                        f4347f0 = new q4(new ad.b(context));
                    }
                } finally {
                }
            }
        }
        return f4347f0;
    }

    public static final void y(com.google.android.gms.internal.measurement.a3 a3Var, int i, String str) {
        List listH = a3Var.h();
        for (int i10 = 0; i10 < listH.size(); i10++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.e3) listH.get(i10)).q())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
        d3VarB.h("_err");
        d3VarB.j(i);
        com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) d3VarB.e();
        com.google.android.gms.internal.measurement.d3 d3VarB2 = com.google.android.gms.internal.measurement.e3.B();
        d3VarB2.h("_ev");
        d3VarB2.i(str);
        com.google.android.gms.internal.measurement.e3 e3Var2 = (com.google.android.gms.internal.measurement.e3) d3VarB2.e();
        a3Var.k(e3Var);
        a3Var.k(e3Var2);
    }

    public static final void z(com.google.android.gms.internal.measurement.a3 a3Var, String str) {
        List listH = a3Var.h();
        for (int i = 0; i < listH.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.e3) listH.get(i)).q())) {
                a3Var.m(i);
                return;
            }
        }
    }

    public final int A(String str, p6.c cVar) {
        d2 d2VarQ1;
        l1 l1Var = this.f4353v;
        com.google.android.gms.internal.measurement.a2 a2VarH1 = l1Var.H1(str);
        f2 f2Var = f2.f4173z;
        if (a2VarH1 == null) {
            cVar.B(f2Var, h.FAILSAFE);
            return 1;
        }
        n nVar = this.f4355x;
        P(nVar);
        b1 b1VarO2 = nVar.o2(str);
        if (b1VarO2 == null || ((d2) p6.d.C(b1VarO2.s()).f10037w) != d2.f4071x || (d2VarQ1 = l1Var.q1(str, f2Var)) == d2.f4070w) {
            cVar.B(f2Var, h.REMOTE_DEFAULT);
            if (l1Var.G1(str, f2Var)) {
                return 0;
            }
        } else {
            cVar.B(f2Var, h.REMOTE_ENFORCED_DEFAULT);
            if (d2VarQ1 == d2.f4073z) {
                return 0;
            }
        }
        return 1;
    }

    @Override // f9.c2
    public final s8.a A0() {
        r1 r1Var = this.G;
        o8.u.g(r1Var);
        return r1Var.F;
    }

    public final HashMap B(com.google.android.gms.internal.measurement.b3 b3Var) {
        Serializable serializableB1;
        HashMap map = new HashMap();
        g0();
        HashMap map2 = new HashMap();
        for (com.google.android.gms.internal.measurement.e3 e3Var : b3Var.p()) {
            if (e3Var.q().startsWith("gad_") && (serializableB1 = a1.B1(e3Var)) != null) {
                map2.put(e3Var.q(), serializableB1);
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    @Override // f9.c2
    public final w0 C() {
        r1 r1Var = this.G;
        o8.u.g(r1Var);
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        return w0Var;
    }

    public final void D() {
        a0().m1();
        if (this.L.isEmpty()) {
            return;
        }
        if (this.f4350c0 == null) {
            this.f4350c0 = new z3(this, this.G, 2);
        }
        if (this.f4350c0.f4298c != 0) {
            return;
        }
        A0().getClass();
        long jMax = Math.max(0L, ((long) ((Integer) f0.C0.a(null)).intValue()) - (SystemClock.elapsedRealtime() - this.f4351d0));
        C().J.b(Long.valueOf(jMax), "Scheduling notify next app runnable, delay in ms");
        if (this.f4350c0 == null) {
            this.f4350c0 = new z3(this, this.G, 2);
        }
        this.f4350c0.b(jMax);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:8|(3:9|10|(4:12|13|(4:15|(1:22)|25|471)(18:26|27|(2:35|(3:37|(1:44)(1:43)|45)(0))(1:34)|46|(2:48|(3:50|(4:53|(1:476)(2:59|473)|60|51)|472))|61|62|(4:64|65|(0)(1:71)|(7:117|(5:121|(2:123|487)(2:124|(2:126|486)(1:488))|127|118|119)|485|128|(2:131|(3:137|(1:139)(2:140|(3:142|(3:145|(1:147)(1:504)|143)|503))|148)(2:135|136))(1:130)|149|(2:151|(6:(2:156|(6:158|159|193|(9:195|(4:198|(2:211|(2:213|490)(1:492))(5:202|(5:205|(2:208|206)|494|209|203)|493|210|491)|214|196)|489|215|(4:218|(3:496|220|499)(1:498)|497|216)|495|221|(1:223)|500)(1:224)|225|470))|160|193|(0)(0)|225|470)(7:161|162|192|193|(0)(0)|225|470))(2:163|(8:165|(6:(2:170|(6:172|159|193|(0)(0)|225|470))|173|193|(0)(0)|225|470)|162|192|193|(0)(0)|225|470)(7:174|(2:185|(2:186|(2:188|(2:502|190)(1:191))(1:501)))(0)|192|193|(0)(0)|225|470)))(3:136|149|(0)(0)))(1:72)|70|(3:73|74|(3:76|(2:78|479)(2:79|(2:81|480)(2:82|478))|83)(1:477))|84|(1:87)|(1:89)|90|(1:92)(1:93)|94|(4:99|(4:102|(2:104|483)(2:105|(2:107|482)(1:484))|108|100)|481|(1:(1:114)(1:115))(1:(1:111)(2:112|(0)(0))))|(0)(0))|226)(1:469))|227|(3:229|(2:231|(2:233|507)(2:234|(1:508)(3:236|(1:238)(1:239)|(1:510)(2:243|506))))(0)|244)|505|245|(3:246|247|(1:511)(2:249|(2:512|251)(1:513)))|252|(1:254)(2:255|(1:257))|258|(1:260)(1:261)|262|(1:264)(1:265)|266|(6:269|(1:271)|272|(2:274|515)(1:516)|275|267)|514|276|(2:281|(1:285))(1:280)|286|(1:288)|289|(1:291)|292|(2:294|(1:300))|301|(8:303|(8:307|308|(4:310|(2:312|(1:314))|(1:331)(5:318|(1:322)|324|(1:329)(1:328)|330)|332)(3:334|(4:467|336|341|(6:343|(3:346|(3:521|348|(3:350|354|(1:356)(6:357|(1:361)|362|(1:364)(1:366)|365|(3:368|(1:376)|377)(4:378|(3:380|(1:382)|383)(4:384|(1:386)(1:387)|388|(3:390|(1:392)|393)(2:394|(1:396)))|397|518)))(2:351|(0)(0)))(1:352)|344)|520|353|354|(0)(0))(3:353|354|(0)(0)))(3:340|341|(0)(0))|398)|333|519|398|304|305)|517|399|(1:401)|402|(2:405|403)|522)(1:406)|407|(1:409)(13:411|(9:413|(1:415)(1:416)|417|(1:419)(1:420)|421|(1:423)(1:424)|425|(1:427)(1:428)|429)|430|(3:432|(2:438|(1:440)(1:441))(1:437)|442)|443|(3:(2:447|524)(1:525)|448|444)|523|449|(1:451)|452|465|453|457)|410|430|(0)|443|(1:444)|523|449|(0)|452|465|453|457) */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0f20, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0f21, code lost:
    
        ((f9.r1) r2.f307w).C().q1().c(f9.w0.u1(r1), r0, "Failed to remove unused event metadata. appId");
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f6 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0415 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0430 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ef A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0538 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05e8 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x074e A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0b18 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0b4c A[PHI: r2
      0x0b4c: PHI (r2v54 long) = (r2v53 long), (r2v77 long) binds: [B:342:0x0b16, B:520:0x0b4c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0b64 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0b87 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0e33 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0ec0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0ef1 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x0019, B:5:0x0035, B:8:0x003e, B:9:0x005e, B:12:0x0076, B:15:0x00a4, B:17:0x00e1, B:20:0x00fa, B:22:0x0104, B:226:0x0712, B:26:0x0132, B:29:0x0144, B:31:0x014a, B:46:0x018e, B:48:0x01a0, B:51:0x01c7, B:53:0x01cd, B:55:0x01dd, B:57:0x01eb, B:59:0x01fb, B:60:0x0206, B:61:0x0209, B:64:0x0221, B:73:0x0252, B:76:0x025c, B:78:0x026a, B:83:0x02c6, B:79:0x028e, B:81:0x029e, B:87:0x02d5, B:89:0x02ff, B:90:0x0327, B:92:0x035c, B:94:0x0362, B:97:0x036e, B:99:0x03a3, B:100:0x03c0, B:102:0x03c6, B:104:0x03d4, B:108:0x03e8, B:105:0x03dc, B:111:0x03ef, B:114:0x03f6, B:115:0x0415, B:117:0x0430, B:118:0x043c, B:121:0x0446, B:127:0x0469, B:124:0x0458, B:149:0x04e3, B:151:0x04ef, B:154:0x0500, B:156:0x0511, B:158:0x051d, B:193:0x05e2, B:195:0x05e8, B:196:0x05f4, B:198:0x05fa, B:200:0x060a, B:202:0x0614, B:203:0x0627, B:205:0x062d, B:206:0x0646, B:208:0x064c, B:209:0x066a, B:210:0x0678, B:214:0x069f, B:211:0x067e, B:213:0x068a, B:215:0x06a6, B:216:0x06c3, B:218:0x06c9, B:220:0x06dc, B:221:0x06e9, B:223:0x06f0, B:225:0x06fe, B:163:0x0538, B:165:0x0546, B:168:0x0557, B:170:0x0568, B:172:0x0574, B:174:0x0583, B:176:0x0592, B:179:0x059e, B:181:0x05a8, B:183:0x05b2, B:186:0x05bd, B:188:0x05c3, B:190:0x05d3, B:191:0x05de, B:131:0x0471, B:133:0x047d, B:135:0x0489, B:148:0x04cd, B:140:0x04a5, B:143:0x04b7, B:145:0x04bd, B:147:0x04c7, B:35:0x0154, B:37:0x0161, B:39:0x016f, B:41:0x0175, B:45:0x0180, B:229:0x072b, B:231:0x073d, B:233:0x0746, B:244:0x0776, B:234:0x074e, B:236:0x0757, B:238:0x075d, B:241:0x0769, B:243:0x0771, B:245:0x0779, B:246:0x0785, B:249:0x078d, B:251:0x079f, B:252:0x07aa, B:254:0x07b2, B:258:0x07e1, B:260:0x07fd, B:262:0x0812, B:264:0x082e, B:266:0x0843, B:267:0x085f, B:269:0x0865, B:271:0x087d, B:272:0x088b, B:274:0x089b, B:275:0x08a9, B:276:0x08ac, B:278:0x08f6, B:280:0x08fc, B:286:0x0927, B:288:0x092f, B:289:0x094d, B:291:0x0953, B:292:0x0967, B:294:0x097e, B:296:0x098f, B:298:0x09a1, B:300:0x09ab, B:301:0x09ae, B:303:0x0a09, B:304:0x0a1c, B:307:0x0a24, B:310:0x0a43, B:312:0x0a5c, B:314:0x0a71, B:316:0x0a76, B:318:0x0a7a, B:320:0x0a7e, B:322:0x0a88, B:324:0x0a91, B:326:0x0a95, B:328:0x0a9b, B:330:0x0aa6, B:332:0x0ab4, B:398:0x0d1b, B:334:0x0abd, B:336:0x0adb, B:341:0x0af8, B:343:0x0b18, B:344:0x0b20, B:346:0x0b26, B:348:0x0b38, B:354:0x0b4e, B:356:0x0b64, B:357:0x0b87, B:359:0x0b93, B:361:0x0ba9, B:362:0x0be9, B:368:0x0c05, B:370:0x0c10, B:372:0x0c14, B:374:0x0c18, B:376:0x0c1c, B:377:0x0c28, B:378:0x0c2d, B:380:0x0c33, B:382:0x0c4b, B:383:0x0c50, B:397:0x0d18, B:384:0x0c8f, B:386:0x0c94, B:390:0x0ca8, B:392:0x0cc7, B:393:0x0cce, B:396:0x0d0c, B:387:0x0c99, B:339:0x0ae1, B:399:0x0d26, B:401:0x0d33, B:402:0x0d47, B:403:0x0d4f, B:405:0x0d55, B:407:0x0d6b, B:409:0x0d7d, B:430:0x0e2d, B:432:0x0e33, B:434:0x0e48, B:437:0x0e4f, B:442:0x0e92, B:438:0x0e5e, B:440:0x0e6c, B:441:0x0e79, B:443:0x0ea1, B:444:0x0eba, B:447:0x0ec2, B:448:0x0ec7, B:449:0x0ed7, B:451:0x0ef1, B:452:0x0f0e, B:453:0x0f16, B:457:0x0f36, B:456:0x0f21, B:411:0x0d99, B:413:0x0d9f, B:415:0x0daf, B:417:0x0db6, B:423:0x0dcc, B:425:0x0dd3, B:427:0x0e1e, B:429:0x0e25, B:428:0x0e22, B:424:0x0dd0, B:416:0x0db3, B:281:0x090c, B:283:0x0912, B:285:0x0918, B:265:0x0840, B:261:0x080f, B:255:0x07b8, B:257:0x07be, B:458:0x0f3f), top: B:464:0x0019, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E(java.lang.String r47, long r48) {
        /*
            Method dump skipped, instruction units count: 3927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.E(java.lang.String, long):boolean");
    }

    public final void F(com.google.android.gms.internal.measurement.i3 i3Var, long j4, boolean z10) {
        t4 t4Var;
        Object obj;
        String str = true != z10 ? "_lte" : "_se";
        n nVar = this.f4355x;
        P(nVar);
        t4 t4VarG2 = nVar.g2(i3Var.o(), str);
        if (t4VarG2 == null || (obj = t4VarG2.f4425e) == null) {
            String strO = i3Var.o();
            A0().getClass();
            t4Var = new t4(strO, "auto", str, System.currentTimeMillis(), Long.valueOf(j4));
        } else {
            String strO2 = i3Var.o();
            A0().getClass();
            t4Var = new t4(strO2, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j4));
        }
        com.google.android.gms.internal.measurement.r3 r3VarA = com.google.android.gms.internal.measurement.s3.A();
        r3VarA.b();
        ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).C(str);
        A0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        r3VarA.b();
        ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).B(jCurrentTimeMillis);
        Object obj2 = t4Var.f4425e;
        long jLongValue = ((Long) obj2).longValue();
        r3VarA.b();
        ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).F(jLongValue);
        com.google.android.gms.internal.measurement.s3 s3Var = (com.google.android.gms.internal.measurement.s3) r3VarA.e();
        int iA2 = a1.a2(i3Var, str);
        if (iA2 >= 0) {
            i3Var.b();
            ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).c0(iA2, s3Var);
        } else {
            i3Var.b();
            ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).d0(s3Var);
        }
        if (j4 > 0) {
            n nVar2 = this.f4355x;
            P(nVar2);
            nVar2.f2(t4Var);
            C().J.c(true != z10 ? "lifetime" : "session-scoped", obj2, "Updated engagement user property. scope, value");
        }
    }

    public final boolean G(com.google.android.gms.internal.measurement.a3 a3Var, com.google.android.gms.internal.measurement.a3 a3Var2) {
        o8.u.b("_e".equals(a3Var.n()));
        g0();
        com.google.android.gms.internal.measurement.e3 e3VarU1 = a1.u1((com.google.android.gms.internal.measurement.b3) a3Var.e(), "_sc");
        String strS = e3VarU1 == null ? null : e3VarU1.s();
        g0();
        com.google.android.gms.internal.measurement.e3 e3VarU12 = a1.u1((com.google.android.gms.internal.measurement.b3) a3Var2.e(), "_pc");
        String strS2 = e3VarU12 != null ? e3VarU12.s() : null;
        if (strS2 == null || !strS2.equals(strS)) {
            return false;
        }
        o8.u.b("_e".equals(a3Var.n()));
        g0();
        com.google.android.gms.internal.measurement.e3 e3VarU13 = a1.u1((com.google.android.gms.internal.measurement.b3) a3Var.e(), "_et");
        if (e3VarU13 == null || !e3VarU13.t() || e3VarU13.u() <= 0) {
            return true;
        }
        long jU = e3VarU13.u();
        g0();
        com.google.android.gms.internal.measurement.e3 e3VarU14 = a1.u1((com.google.android.gms.internal.measurement.b3) a3Var2.e(), "_et");
        if (e3VarU14 != null && e3VarU14.u() > 0) {
            jU += e3VarU14.u();
        }
        g0();
        a1.s1(a3Var2, "_et", Long.valueOf(jU));
        g0();
        a1.s1(a3Var, "_fr", 1L);
        return true;
    }

    public final boolean H() {
        a0().m1();
        i0();
        n nVar = this.f4355x;
        P(nVar);
        if (nVar.W1("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        n nVar2 = this.f4355x;
        P(nVar2);
        return !TextUtils.isEmpty(nVar2.u1());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            Method dump skipped, instruction units count: 1022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.J():void");
    }

    public final void K() {
        a0().m1();
        if (this.O || this.P || this.Q) {
            C().J.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.O), Boolean.valueOf(this.P), Boolean.valueOf(this.Q));
            return;
        }
        C().J.a("Stopping uploading service(s)");
        ArrayList arrayList = this.K;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Runnable) obj).run();
        }
        ArrayList arrayList2 = this.K;
        o8.u.g(arrayList2);
        arrayList2.clear();
    }

    public final Boolean L(b1 b1Var) {
        try {
            long jP = b1Var.P();
            r1 r1Var = this.G;
            if (jP != -2147483648L) {
                if (b1Var.P() == u8.b.a(r1Var.f4363v).b(0, b1Var.D()).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = u8.b.a(r1Var.f4363v).b(0, b1Var.D()).versionName;
                String strN = b1Var.N();
                if (strN != null && strN.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final w4 M(String str) {
        n nVar = this.f4355x;
        P(nVar);
        b1 b1VarO2 = nVar.o2(str);
        if (b1VarO2 != null) {
            r1 r1Var = b1VarO2.f4024a;
            if (!TextUtils.isEmpty(b1VarO2.N())) {
                Boolean boolL = L(b1VarO2);
                if (boolL != null && !boolL.booleanValue()) {
                    C().B.b(w0.u1(str), "App version does not match; dropping. appId");
                    return null;
                }
                String strG = b1VarO2.G();
                String strN = b1VarO2.N();
                long jP = b1VarO2.P();
                p1 p1Var = r1Var.B;
                r1.g(p1Var);
                p1Var.m1();
                String str2 = b1VarO2.f4033l;
                p1 p1Var2 = r1Var.B;
                r1.g(p1Var2);
                p1Var2.m1();
                long j4 = b1VarO2.f4034m;
                p1 p1Var3 = r1Var.B;
                r1.g(p1Var3);
                p1Var3.m1();
                long j7 = b1VarO2.f4035n;
                p1 p1Var4 = r1Var.B;
                r1.g(p1Var4);
                p1Var4.m1();
                boolean z10 = b1VarO2.f4036o;
                String strJ = b1VarO2.J();
                p1 p1Var5 = r1Var.B;
                r1.g(p1Var5);
                p1Var5.m1();
                boolean z11 = b1VarO2.f4037p;
                Boolean boolW = b1VarO2.w();
                long jB = b1VarO2.b();
                p1 p1Var6 = r1Var.B;
                r1.g(p1Var6);
                p1Var6.m1();
                ArrayList arrayList = b1VarO2.f4040s;
                String strG2 = a(str).g();
                boolean zY = b1VarO2.y();
                p1 p1Var7 = r1Var.B;
                r1.g(p1Var7);
                p1Var7.m1();
                long j10 = b1VarO2.f4043v;
                int i = a(str).f4190b;
                String str3 = l0(str).f4315b;
                p1 p1Var8 = r1Var.B;
                r1.g(p1Var8);
                p1Var8.m1();
                int i10 = b1VarO2.f4045x;
                p1 p1Var9 = r1Var.B;
                r1.g(p1Var9);
                p1Var9.m1();
                return new w4(str, strG, strN, jP, str2, j4, j7, (String) null, z10, false, strJ, 0L, 0, z11, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j10, i, str3, i10, b1VarO2.B, b1VarO2.C(), b1VarO2.s(), 0L, b1VarO2.t());
            }
        }
        C().I.b(str, "No app data available; dropping");
        return null;
    }

    public final boolean N(String str, String str2) {
        n nVar = this.f4355x;
        P(nVar);
        s sVarK1 = nVar.K1("events", str, str2);
        return sVarK1 == null || sVarK1.f4382c < 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(f9.s4 r24, f9.w4 r25) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.R(f9.s4, f9.w4):void");
    }

    public final void S(String str, w4 w4Var) {
        a0().m1();
        i0();
        boolean zO = O(w4Var);
        String str2 = w4Var.f4462v;
        if (zO) {
            if (!w4Var.C) {
                X(w4Var);
                return;
            }
            Boolean boolQ = Q(w4Var);
            if ("_npa".equals(str) && boolQ != null) {
                C().I.a("Falling back to manifest metadata value for ad personalization");
                A0().getClass();
                R(new s4(System.currentTimeMillis(), Long.valueOf(true != boolQ.booleanValue() ? 0L : 1L), "_npa", "auto"), w4Var);
                return;
            }
            u0 u0Var = C().I;
            r1 r1Var = this.G;
            u0Var.b(r1Var.E.c(str), "Removing user property");
            n nVar = this.f4355x;
            P(nVar);
            nVar.Y1();
            try {
                X(w4Var);
                if ("_id".equals(str)) {
                    n nVar2 = this.f4355x;
                    P(nVar2);
                    o8.u.g(str2);
                    nVar2.e2(str2, "_lair");
                }
                n nVar3 = this.f4355x;
                P(nVar3);
                o8.u.g(str2);
                nVar3.e2(str2, str);
                n nVar4 = this.f4355x;
                P(nVar4);
                nVar4.Z1();
                C().I.b(r1Var.E.c(str), "User property removed");
                n nVar5 = this.f4355x;
                P(nVar5);
                nVar5.a2();
            } catch (Throwable th) {
                n nVar6 = this.f4355x;
                P(nVar6);
                nVar6.a2();
                throw th;
            }
        }
    }

    @Override // f9.c2
    public final jb.b S0() {
        return this.G.f4365x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0422 A[Catch: all -> 0x02ca, TryCatch #3 {all -> 0x02ca, blocks: (B:105:0x0297, B:107:0x02b5, B:150:0x037e, B:151:0x0381, B:153:0x038e, B:154:0x039e, B:165:0x0446, B:112:0x02cd, B:117:0x02ed, B:119:0x02f5, B:121:0x02fc, B:125:0x030f, B:129:0x0321, B:133:0x032d, B:136:0x0340, B:141:0x035f, B:143:0x0367, B:145:0x036f, B:147:0x0375, B:139:0x034d, B:127:0x031a, B:115:0x02db, B:155:0x03b7, B:157:0x03ec, B:158:0x03ef, B:160:0x03fc, B:161:0x040a, B:162:0x0422, B:164:0x042a), top: B:176:0x0138, inners: #0, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[Catch: all -> 0x00c4, TryCatch #2 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x011f, B:56:0x013a, B:59:0x0153, B:67:0x019b, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:174:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114 A[Catch: all -> 0x00c4, TryCatch #2 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x011f, B:56:0x013a, B:59:0x0153, B:67:0x019b, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:174:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f A[Catch: all -> 0x00c4, TRY_ENTER, TryCatch #2 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x011f, B:56:0x013a, B:59:0x0153, B:67:0x019b, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:174:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x00c4, TryCatch #2 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x011f, B:56:0x013a, B:59:0x0153, B:67:0x019b, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:174:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013a A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #2 {all -> 0x00c4, blocks: (B:24:0x00a4, B:26:0x00b4, B:34:0x00cc, B:38:0x00dc, B:40:0x00eb, B:46:0x0100, B:48:0x010d, B:50:0x0118, B:53:0x011f, B:56:0x013a, B:59:0x0153, B:67:0x019b, B:54:0x012c, B:49:0x0114, B:42:0x00f5, B:45:0x00fd), top: B:174:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017d  */
    /* JADX WARN: Type inference failed for: r2v0, types: [f9.w4, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [f9.q4] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v5, types: [f9.q4] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(f9.w4 r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.T(f9.w4):void");
    }

    public final void U(e eVar, w4 w4Var) {
        v vVar;
        o8.u.d(eVar.f4083v);
        o8.u.g(eVar.f4084w);
        o8.u.g(eVar.f4085x);
        o8.u.d(eVar.f4085x.f4404w);
        a0().m1();
        i0();
        if (O(w4Var)) {
            if (!w4Var.C) {
                X(w4Var);
                return;
            }
            e eVar2 = new e(eVar);
            boolean z10 = false;
            eVar2.f4087z = false;
            n nVar = this.f4355x;
            P(nVar);
            nVar.Y1();
            try {
                n nVar2 = this.f4355x;
                P(nVar2);
                String str = eVar2.f4083v;
                o8.u.g(str);
                e eVarK2 = nVar2.k2(str, eVar2.f4085x.f4404w);
                r1 r1Var = this.G;
                if (eVarK2 != null && !eVarK2.f4084w.equals(eVar2.f4084w)) {
                    C().E.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", r1Var.E.c(eVar2.f4085x.f4404w), eVar2.f4084w, eVarK2.f4084w);
                }
                if (eVarK2 != null && eVarK2.f4087z) {
                    eVar2.f4084w = eVarK2.f4084w;
                    eVar2.f4086y = eVarK2.f4086y;
                    eVar2.C = eVarK2.C;
                    eVar2.A = eVarK2.A;
                    eVar2.D = eVarK2.D;
                    eVar2.f4087z = true;
                    s4 s4Var = eVar2.f4085x;
                    eVar2.f4085x = new s4(eVarK2.f4085x.f4405x, s4Var.a(), s4Var.f4404w, eVarK2.f4085x.A);
                } else if (TextUtils.isEmpty(eVar2.A)) {
                    s4 s4Var2 = eVar2.f4085x;
                    eVar2.f4085x = new s4(eVar2.f4086y, s4Var2.a(), s4Var2.f4404w, eVar2.f4085x.A);
                    eVar2.f4087z = true;
                    z10 = true;
                }
                if (eVar2.f4087z) {
                    s4 s4Var3 = eVar2.f4085x;
                    String str2 = eVar2.f4083v;
                    o8.u.g(str2);
                    String str3 = eVar2.f4084w;
                    String str4 = s4Var3.f4404w;
                    long j4 = s4Var3.f4405x;
                    Object objA = s4Var3.a();
                    o8.u.g(objA);
                    t4 t4Var = new t4(str2, str3, str4, j4, objA);
                    Object obj = t4Var.f4425e;
                    String str5 = t4Var.f4423c;
                    n nVar3 = this.f4355x;
                    P(nVar3);
                    if (nVar3.f2(t4Var)) {
                        C().I.d("User property updated immediately", eVar2.f4083v, r1Var.E.c(str5), obj);
                    } else {
                        C().B.d("(2)Too many active user properties, ignoring", w0.u1(eVar2.f4083v), r1Var.E.c(str5), obj);
                    }
                    if (z10 && (vVar = eVar2.D) != null) {
                        g(new v(vVar, eVar2.f4086y), w4Var);
                    }
                }
                n nVar4 = this.f4355x;
                P(nVar4);
                if (nVar4.j2(eVar2)) {
                    C().I.d("Conditional property added", eVar2.f4083v, r1Var.E.c(eVar2.f4085x.f4404w), eVar2.f4085x.a());
                } else {
                    C().B.d("Too many conditional properties, ignoring", w0.u1(eVar2.f4083v), r1Var.E.c(eVar2.f4085x.f4404w), eVar2.f4085x.a());
                }
                n nVar5 = this.f4355x;
                P(nVar5);
                nVar5.Z1();
                n nVar6 = this.f4355x;
                P(nVar6);
                nVar6.a2();
            } catch (Throwable th) {
                n nVar7 = this.f4355x;
                P(nVar7);
                nVar7.a2();
                throw th;
            }
        }
    }

    public final void V(e eVar, w4 w4Var) {
        o8.u.d(eVar.f4083v);
        o8.u.g(eVar.f4085x);
        o8.u.d(eVar.f4085x.f4404w);
        a0().m1();
        i0();
        if (O(w4Var)) {
            if (!w4Var.C) {
                X(w4Var);
                return;
            }
            n nVar = this.f4355x;
            P(nVar);
            nVar.Y1();
            try {
                X(w4Var);
                String str = eVar.f4083v;
                o8.u.g(str);
                n nVar2 = this.f4355x;
                P(nVar2);
                e eVarK2 = nVar2.k2(str, eVar.f4085x.f4404w);
                r1 r1Var = this.G;
                if (eVarK2 != null) {
                    C().I.c(eVar.f4083v, r1Var.E.c(eVar.f4085x.f4404w), "Removing conditional user property");
                    n nVar3 = this.f4355x;
                    P(nVar3);
                    nVar3.l2(str, eVar.f4085x.f4404w);
                    if (eVarK2.f4087z) {
                        n nVar4 = this.f4355x;
                        P(nVar4);
                        nVar4.e2(str, eVar.f4085x.f4404w);
                    }
                    v vVar = eVar.F;
                    if (vVar != null) {
                        u uVar = vVar.f4442w;
                        v vVarP1 = h0().P1(vVar.f4441v, uVar != null ? uVar.d() : null, eVarK2.f4084w, vVar.f4444y, true);
                        o8.u.g(vVarP1);
                        g(vVarP1, w4Var);
                    }
                } else {
                    C().E.c(w0.u1(eVar.f4083v), r1Var.E.c(eVar.f4085x.f4404w), "Conditional user property doesn't exist");
                }
                n nVar5 = this.f4355x;
                P(nVar5);
                nVar5.Z1();
                n nVar6 = this.f4355x;
                P(nVar6);
                nVar6.a2();
            } catch (Throwable th) {
                n nVar7 = this.f4355x;
                P(nVar7);
                nVar7.a2();
                throw th;
            }
        }
    }

    public final void W(w4 w4Var, long j4) throws Throwable {
        n nVar = this.f4355x;
        P(nVar);
        String str = w4Var.f4462v;
        o8.u.g(str);
        b1 b1VarO2 = nVar.o2(str);
        if (b1VarO2 != null) {
            h0();
            String str2 = w4Var.f4463w;
            String strG = b1VarO2.G();
            boolean zIsEmpty = TextUtils.isEmpty(str2);
            boolean zIsEmpty2 = TextUtils.isEmpty(strG);
            if (!zIsEmpty && !zIsEmpty2) {
                o8.u.g(str2);
                if (!str2.equals(strG)) {
                    C().E.b(w0.u1(b1VarO2.D()), "New GMP App Id passed in. Removing cached database data. appId");
                    n nVar2 = this.f4355x;
                    P(nVar2);
                    r1 r1Var = (r1) nVar2.f307w;
                    String strD = b1VarO2.D();
                    nVar2.n1();
                    nVar2.m1();
                    o8.u.d(strD);
                    try {
                        SQLiteDatabase sQLiteDatabaseB2 = nVar2.b2();
                        String[] strArr = {strD};
                        int iDelete = sQLiteDatabaseB2.delete("events", "app_id=?", strArr) + sQLiteDatabaseB2.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseB2.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseB2.delete("apps", "app_id=?", strArr) + sQLiteDatabaseB2.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseB2.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseB2.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseB2.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseB2.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseB2.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseB2.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseB2.delete("trigger_uris", "app_id=?", strArr);
                        if (r1Var.f4366y.w1(null, f0.f4131i1)) {
                            iDelete += sQLiteDatabaseB2.delete("no_data_mode_events", "app_id=?", strArr);
                        }
                        if (iDelete > 0) {
                            w0 w0Var = r1Var.A;
                            r1.g(w0Var);
                            w0Var.J.c(strD, Integer.valueOf(iDelete), "Deleted application data. app, records");
                        }
                    } catch (SQLiteException e9) {
                        w0 w0Var2 = r1Var.A;
                        r1.g(w0Var2);
                        w0Var2.B.c(w0.u1(strD), e9, "Error deleting application data. appId, error");
                    }
                    b1VarO2 = null;
                }
            }
        }
        if (b1VarO2 != null) {
            boolean z10 = (b1VarO2.P() == -2147483648L || b1VarO2.P() == w4Var.E) ? false : true;
            String strN = b1VarO2.N();
            if (z10 || ((b1VarO2.P() != -2147483648L || strN == null || strN.equals(w4Var.f4464x)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strN);
                v vVar = new v("_au", new u(bundle), "auto", j4);
                if (Z().w1(null, f0.f4118d1)) {
                    d(vVar, w4Var);
                } else {
                    e(vVar, w4Var);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.b1 X(f9.w4 r13) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.X(f9.w4):f9.b1");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List Y(Bundle bundle, w4 w4Var) {
        int[] iArr;
        a0().m1();
        q8.a();
        g gVarZ = Z();
        String str = w4Var.f4462v;
        if (!gVarZ.w1(str, f0.Q0) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    C().B.a("Uri sources and timestamps do not match");
                } else {
                    int i = 0;
                    while (i < intArray.length) {
                        n nVar = this.f4355x;
                        P(nVar);
                        r1 r1Var = (r1) nVar.f307w;
                        int i10 = intArray[i];
                        long j4 = longArray[i];
                        o8.u.d(str);
                        nVar.m1();
                        nVar.n1();
                        try {
                            iArr = intArray;
                        } catch (SQLiteException e9) {
                            e = e9;
                            iArr = intArray;
                        }
                        try {
                            int iDelete = nVar.b2().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i10), String.valueOf(j4)});
                            w0 w0Var = r1Var.A;
                            r1.g(w0Var);
                            u0 u0Var = w0Var.J;
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            u0Var.d(sb.toString(), str, Integer.valueOf(i10), Long.valueOf(j4));
                        } catch (SQLiteException e10) {
                            e = e10;
                            w0 w0Var2 = r1Var.A;
                            r1.g(w0Var2);
                            w0Var2.B.c(w0.u1(str), e, "Error pruning trigger URIs. appId");
                        }
                        i++;
                        intArray = iArr;
                    }
                }
            }
        }
        n nVar2 = this.f4355x;
        P(nVar2);
        String str2 = w4Var.f4462v;
        o8.u.d(str2);
        nVar2.m1();
        nVar2.n1();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = nVar2.b2().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new f4(cursorQuery.getInt(2), cursorQuery.getLong(1), string));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            w0 w0Var3 = ((r1) nVar2.f307w).A;
            r1.g(w0Var3);
            w0Var3.B.c(w0.u1(str2), e11, "Error querying trigger uris. appId");
            arrayList = Collections.EMPTY_LIST;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final g Z() {
        r1 r1Var = this.G;
        o8.u.g(r1Var);
        return r1Var.f4366y;
    }

    public final g2 a(String str) {
        g2 g2Var = g2.f4188c;
        a0().m1();
        i0();
        HashMap map = this.W;
        g2 g2VarF1 = (g2) map.get(str);
        if (g2VarF1 == null) {
            n nVar = this.f4355x;
            P(nVar);
            g2VarF1 = nVar.F1(str);
            if (g2VarF1 == null) {
                g2VarF1 = g2.f4188c;
            }
            a0().m1();
            i0();
            map.put(str, g2VarF1);
            n nVar2 = this.f4355x;
            P(nVar2);
            nVar2.H1(str, g2VarF1);
        }
        return g2VarF1;
    }

    @Override // f9.c2
    public final p1 a0() {
        r1 r1Var = this.G;
        o8.u.g(r1Var);
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        return p1Var;
    }

    public final long b() {
        A0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        v3 v3Var = this.D;
        v3Var.n1();
        v3Var.m1();
        e1 e1Var = v3Var.F;
        long jC = e1Var.c();
        if (jC == 0) {
            u4 u4Var = ((r1) v3Var.f307w).D;
            r1.e(u4Var);
            jC = ((long) u4Var.k2().nextInt(86400000)) + 1;
            e1Var.e(jC);
        }
        return ((((jCurrentTimeMillis + jC) / 1000) / 60) / 60) / 24;
    }

    public final l1 b0() {
        l1 l1Var = this.f4353v;
        P(l1Var);
        return l1Var;
    }

    public final void c(v vVar, String str) {
        n nVar = this.f4355x;
        P(nVar);
        b1 b1VarO2 = nVar.o2(str);
        if (b1VarO2 != null) {
            r1 r1Var = b1VarO2.f4024a;
            if (!TextUtils.isEmpty(b1VarO2.N())) {
                Boolean boolL = L(b1VarO2);
                if (boolL == null) {
                    if (!"_ui".equals(vVar.f4441v)) {
                        C().E.b(w0.u1(str), "Could not find package. appId");
                    }
                } else if (!boolL.booleanValue()) {
                    C().B.b(w0.u1(str), "App version does not match; dropping event. appId");
                    return;
                }
                String strG = b1VarO2.G();
                String strN = b1VarO2.N();
                long jP = b1VarO2.P();
                p1 p1Var = r1Var.B;
                r1.g(p1Var);
                p1Var.m1();
                String str2 = b1VarO2.f4033l;
                p1 p1Var2 = r1Var.B;
                r1.g(p1Var2);
                p1Var2.m1();
                long j4 = b1VarO2.f4034m;
                p1 p1Var3 = r1Var.B;
                r1.g(p1Var3);
                p1Var3.m1();
                long j7 = b1VarO2.f4035n;
                p1 p1Var4 = r1Var.B;
                r1.g(p1Var4);
                p1Var4.m1();
                boolean z10 = b1VarO2.f4036o;
                String strJ = b1VarO2.J();
                p1 p1Var5 = r1Var.B;
                r1.g(p1Var5);
                p1Var5.m1();
                boolean z11 = b1VarO2.f4037p;
                Boolean boolW = b1VarO2.w();
                long jB = b1VarO2.b();
                p1 p1Var6 = r1Var.B;
                r1.g(p1Var6);
                p1Var6.m1();
                ArrayList arrayList = b1VarO2.f4040s;
                String strG2 = a(str).g();
                boolean zY = b1VarO2.y();
                p1 p1Var7 = r1Var.B;
                r1.g(p1Var7);
                p1Var7.m1();
                long j10 = b1VarO2.f4043v;
                int i = a(str).f4190b;
                String str3 = l0(str).f4315b;
                p1 p1Var8 = r1Var.B;
                r1.g(p1Var8);
                p1Var8.m1();
                int i10 = b1VarO2.f4045x;
                p1 p1Var9 = r1Var.B;
                r1.g(p1Var9);
                p1Var9.m1();
                d(vVar, new w4(str, strG, strN, jP, str2, j4, j7, (String) null, z10, false, strJ, 0L, 0, z11, false, boolW, jB, (List) arrayList, strG2, "", (String) null, zY, j10, i, str3, i10, b1VarO2.B, b1VarO2.C(), b1VarO2.s(), 0L, b1VarO2.t()));
                return;
            }
        }
        C().I.b(str, "No app data available; dropping event");
    }

    public final n c0() {
        n nVar = this.f4355x;
        P(nVar);
        return nVar;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0080: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:129), block:B:18:0x0080 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(f9.v r11, f9.w4 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.d(f9.v, f9.w4):void");
    }

    public final c1 d0() {
        c1 c1Var = this.f4356y;
        if (c1Var != null) {
            return c1Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final void e(v vVar, w4 w4Var) {
        v vVar2;
        List listN2;
        r1 r1Var;
        List listN22;
        List<e> listN23;
        String str;
        o8.u.g(w4Var);
        String str2 = w4Var.f4462v;
        o8.u.d(str2);
        a0().m1();
        i0();
        long j4 = vVar.f4444y;
        x0 x0VarC = x0.c(vVar);
        a0().m1();
        u4.e2((this.f4348a0 == null || (str = this.f4349b0) == null || !str.equals(str2)) ? null : this.f4348a0, (Bundle) x0VarC.f4474e, false);
        v vVarD = x0VarC.d();
        g0();
        if (TextUtils.isEmpty(w4Var.f4463w)) {
            return;
        }
        if (!w4Var.C) {
            X(w4Var);
            return;
        }
        List list = w4Var.M;
        if (list != null) {
            String str3 = vVarD.f4441v;
            if (!list.contains(str3)) {
                C().I.d("Dropping non-safelisted event. appId, event name, origin", str2, vVarD.f4441v, vVarD.f4443x);
                return;
            } else {
                Bundle bundleD = vVarD.f4442w.d();
                bundleD.putLong("ga_safelisted", 1L);
                vVar2 = new v(str3, new u(bundleD), vVarD.f4443x, vVarD.f4444y);
            }
        } else {
            vVar2 = vVarD;
        }
        n nVar = this.f4355x;
        P(nVar);
        nVar.Y1();
        try {
            String str4 = vVar2.f4441v;
            if ("_s".equals(str4)) {
                n nVar2 = this.f4355x;
                P(nVar2);
                if (!nVar2.B1(str2, "_s") && vVar2.f4442w.f4426v.getLong("_sid") != 0) {
                    n nVar3 = this.f4355x;
                    P(nVar3);
                    if (nVar3.B1(str2, "_f")) {
                        n nVar4 = this.f4355x;
                        P(nVar4);
                        nVar4.E1(str2, null, "_sid", f(vVar2, str2));
                    } else {
                        n nVar5 = this.f4355x;
                        P(nVar5);
                        if (nVar5.B1(str2, "_v")) {
                            n nVar42 = this.f4355x;
                            P(nVar42);
                            nVar42.E1(str2, null, "_sid", f(vVar2, str2));
                        } else {
                            n nVar6 = this.f4355x;
                            P(nVar6);
                            A0().getClass();
                            nVar6.E1(str2, Long.valueOf(System.currentTimeMillis() - 15000), "_sid", f(vVar2, str2));
                        }
                    }
                }
            }
            n nVar7 = this.f4355x;
            P(nVar7);
            o8.u.d(str2);
            nVar7.m1();
            nVar7.n1();
            if (j4 < 0) {
                w0 w0Var = ((r1) nVar7.f307w).A;
                r1.g(w0Var);
                w0Var.E.c(w0.u1(str2), Long.valueOf(j4), "Invalid time querying timed out conditional properties");
                listN2 = Collections.EMPTY_LIST;
            } else {
                listN2 = nVar7.n2("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j4)});
            }
            Iterator it = listN2.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                r1Var = this.G;
                if (!zHasNext) {
                    break;
                }
                e eVar = (e) it.next();
                if (eVar != null) {
                    C().J.d("User property timed out", eVar.f4083v, r1Var.E.c(eVar.f4085x.f4404w), eVar.f4085x.a());
                    v vVar3 = eVar.B;
                    if (vVar3 != null) {
                        g(new v(vVar3, j4), w4Var);
                    }
                    n nVar8 = this.f4355x;
                    P(nVar8);
                    nVar8.l2(str2, eVar.f4085x.f4404w);
                }
            }
            n nVar9 = this.f4355x;
            P(nVar9);
            o8.u.d(str2);
            nVar9.m1();
            nVar9.n1();
            if (j4 < 0) {
                w0 w0Var2 = ((r1) nVar9.f307w).A;
                r1.g(w0Var2);
                w0Var2.E.c(w0.u1(str2), Long.valueOf(j4), "Invalid time querying expired conditional properties");
                listN22 = Collections.EMPTY_LIST;
            } else {
                listN22 = nVar9.n2("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j4)});
            }
            ArrayList arrayList = new ArrayList(listN22.size());
            Iterator it2 = listN22.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next();
                if (eVar2 != null) {
                    Iterator it3 = it2;
                    C().J.d("User property expired", eVar2.f4083v, r1Var.E.c(eVar2.f4085x.f4404w), eVar2.f4085x.a());
                    n nVar10 = this.f4355x;
                    P(nVar10);
                    nVar10.e2(str2, eVar2.f4085x.f4404w);
                    v vVar4 = eVar2.F;
                    if (vVar4 != null) {
                        arrayList.add(vVar4);
                    }
                    n nVar11 = this.f4355x;
                    P(nVar11);
                    nVar11.l2(str2, eVar2.f4085x.f4404w);
                    it2 = it3;
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                g(new v((v) obj, j4), w4Var);
            }
            n nVar12 = this.f4355x;
            P(nVar12);
            o8.u.d(str2);
            o8.u.d(str4);
            nVar12.m1();
            nVar12.n1();
            if (j4 < 0) {
                r1 r1Var2 = (r1) nVar12.f307w;
                w0 w0Var3 = r1Var2.A;
                r1.g(w0Var3);
                w0Var3.E.d("Invalid time querying triggered conditional properties", w0.u1(str2), r1Var2.E.a(str4), Long.valueOf(j4));
                listN23 = Collections.EMPTY_LIST;
            } else {
                listN23 = nVar12.n2("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j4)});
            }
            ArrayList arrayList2 = new ArrayList(listN23.size());
            for (e eVar3 : listN23) {
                if (eVar3 != null) {
                    s4 s4Var = eVar3.f4085x;
                    String str5 = eVar3.f4083v;
                    o8.u.g(str5);
                    String str6 = eVar3.f4084w;
                    String str7 = s4Var.f4404w;
                    Object objA = s4Var.a();
                    o8.u.g(objA);
                    t4 t4Var = new t4(str5, str6, str7, j4, objA);
                    Object obj2 = t4Var.f4425e;
                    String str8 = t4Var.f4423c;
                    n nVar13 = this.f4355x;
                    P(nVar13);
                    if (nVar13.f2(t4Var)) {
                        C().J.d("User property triggered", eVar3.f4083v, r1Var.E.c(str8), obj2);
                    } else {
                        C().B.d("Too many active user properties, ignoring", w0.u1(eVar3.f4083v), r1Var.E.c(str8), obj2);
                    }
                    v vVar5 = eVar3.D;
                    if (vVar5 != null) {
                        arrayList2.add(vVar5);
                    }
                    eVar3.f4085x = new s4(t4Var);
                    eVar3.f4087z = true;
                    n nVar14 = this.f4355x;
                    P(nVar14);
                    nVar14.j2(eVar3);
                }
            }
            g(vVar2, w4Var);
            int size2 = arrayList2.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj3 = arrayList2.get(i10);
                i10++;
                g(new v((v) obj3, j4), w4Var);
            }
            n nVar15 = this.f4355x;
            P(nVar15);
            nVar15.Z1();
            n nVar16 = this.f4355x;
            P(nVar16);
            nVar16.a2();
        } catch (Throwable th) {
            n nVar17 = this.f4355x;
            P(nVar17);
            nVar17.a2();
            throw th;
        }
    }

    public final c e0() {
        c cVar = this.A;
        P(cVar);
        return cVar;
    }

    public final Bundle f(v vVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", vVar.f4442w.f4426v.getLong("_sid"));
        n nVar = this.f4355x;
        P(nVar);
        t4 t4VarG2 = nVar.g2(str, "_sno");
        if (t4VarG2 != null) {
            Object obj = t4VarG2.f4425e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    @Override // f9.c2
    public final Context f0() {
        return this.G.f4363v;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:74|(12:76|(0)(1:79)|80|87|(1:89)|91|(0)(0)|94|102|(0)(0)|157|158)|78|81|396|82|86|80|87|(0)(0)|91|(0)(0)|94|102|(0)(0)|157|158) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02fe, code lost:
    
        ((f9.r1) r10.f307w).C().q1().c(f9.w0.u1(r13), r0, "Error pruning currencies. appId");
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03e5 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036c, B:102:0x03a9, B:104:0x03e5, B:106:0x03ea, B:107:0x0401, B:109:0x040c, B:111:0x0426, B:113:0x042c, B:114:0x0443, B:117:0x0462, B:121:0x0484, B:122:0x049b, B:123:0x04a4, B:126:0x04c1, B:127:0x04d5, B:129:0x04dd, B:131:0x04e7, B:133:0x04ed, B:134:0x04f4, B:136:0x0501, B:138:0x0509, B:140:0x0511, B:142:0x0519, B:143:0x0525, B:144:0x0532, B:150:0x057a, B:151:0x058f, B:153:0x05be, B:156:0x05e8, B:160:0x0638, B:163:0x0666, B:165:0x0695, B:166:0x0698, B:168:0x069e, B:170:0x06a6, B:172:0x06ac, B:174:0x06b4, B:176:0x06ba, B:180:0x06c9, B:183:0x06d8, B:185:0x06e1, B:187:0x06e9, B:190:0x071a, B:192:0x0723, B:196:0x0738, B:201:0x0745, B:236:0x07c0, B:237:0x07c7, B:239:0x07ea, B:242:0x07f3, B:246:0x07fe, B:247:0x0818, B:249:0x081e, B:251:0x0838, B:253:0x0844, B:255:0x0851, B:262:0x0886, B:266:0x0890, B:267:0x0893, B:269:0x08a0, B:270:0x08a3, B:281:0x08e7, B:260:0x0872, B:240:0x07ed, B:204:0x074e, B:208:0x075b, B:212:0x0769, B:216:0x0777, B:220:0x0785, B:224:0x0793, B:228:0x079f, B:232:0x07ad, B:162:0x0659, B:147:0x055f, B:95:0x037e, B:96:0x038a, B:98:0x0390, B:100:0x039e, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032e, B:89:0x0338, B:81:0x02d2, B:82:0x02eb, B:86:0x0313, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:391:0x01cc, inners: #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x07ba  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0890 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036c, B:102:0x03a9, B:104:0x03e5, B:106:0x03ea, B:107:0x0401, B:109:0x040c, B:111:0x0426, B:113:0x042c, B:114:0x0443, B:117:0x0462, B:121:0x0484, B:122:0x049b, B:123:0x04a4, B:126:0x04c1, B:127:0x04d5, B:129:0x04dd, B:131:0x04e7, B:133:0x04ed, B:134:0x04f4, B:136:0x0501, B:138:0x0509, B:140:0x0511, B:142:0x0519, B:143:0x0525, B:144:0x0532, B:150:0x057a, B:151:0x058f, B:153:0x05be, B:156:0x05e8, B:160:0x0638, B:163:0x0666, B:165:0x0695, B:166:0x0698, B:168:0x069e, B:170:0x06a6, B:172:0x06ac, B:174:0x06b4, B:176:0x06ba, B:180:0x06c9, B:183:0x06d8, B:185:0x06e1, B:187:0x06e9, B:190:0x071a, B:192:0x0723, B:196:0x0738, B:201:0x0745, B:236:0x07c0, B:237:0x07c7, B:239:0x07ea, B:242:0x07f3, B:246:0x07fe, B:247:0x0818, B:249:0x081e, B:251:0x0838, B:253:0x0844, B:255:0x0851, B:262:0x0886, B:266:0x0890, B:267:0x0893, B:269:0x08a0, B:270:0x08a3, B:281:0x08e7, B:260:0x0872, B:240:0x07ed, B:204:0x074e, B:208:0x075b, B:212:0x0769, B:216:0x0777, B:220:0x0785, B:224:0x0793, B:228:0x079f, B:232:0x07ad, B:162:0x0659, B:147:0x055f, B:95:0x037e, B:96:0x038a, B:98:0x0390, B:100:0x039e, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032e, B:89:0x0338, B:81:0x02d2, B:82:0x02eb, B:86:0x0313, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:391:0x01cc, inners: #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x08a0 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036c, B:102:0x03a9, B:104:0x03e5, B:106:0x03ea, B:107:0x0401, B:109:0x040c, B:111:0x0426, B:113:0x042c, B:114:0x0443, B:117:0x0462, B:121:0x0484, B:122:0x049b, B:123:0x04a4, B:126:0x04c1, B:127:0x04d5, B:129:0x04dd, B:131:0x04e7, B:133:0x04ed, B:134:0x04f4, B:136:0x0501, B:138:0x0509, B:140:0x0511, B:142:0x0519, B:143:0x0525, B:144:0x0532, B:150:0x057a, B:151:0x058f, B:153:0x05be, B:156:0x05e8, B:160:0x0638, B:163:0x0666, B:165:0x0695, B:166:0x0698, B:168:0x069e, B:170:0x06a6, B:172:0x06ac, B:174:0x06b4, B:176:0x06ba, B:180:0x06c9, B:183:0x06d8, B:185:0x06e1, B:187:0x06e9, B:190:0x071a, B:192:0x0723, B:196:0x0738, B:201:0x0745, B:236:0x07c0, B:237:0x07c7, B:239:0x07ea, B:242:0x07f3, B:246:0x07fe, B:247:0x0818, B:249:0x081e, B:251:0x0838, B:253:0x0844, B:255:0x0851, B:262:0x0886, B:266:0x0890, B:267:0x0893, B:269:0x08a0, B:270:0x08a3, B:281:0x08e7, B:260:0x0872, B:240:0x07ed, B:204:0x074e, B:208:0x075b, B:212:0x0769, B:216:0x0777, B:220:0x0785, B:224:0x0793, B:228:0x079f, B:232:0x07ad, B:162:0x0659, B:147:0x055f, B:95:0x037e, B:96:0x038a, B:98:0x0390, B:100:0x039e, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032e, B:89:0x0338, B:81:0x02d2, B:82:0x02eb, B:86:0x0313, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:391:0x01cc, inners: #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0971  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x09b6 A[Catch: all -> 0x094a, TryCatch #5 {all -> 0x094a, blocks: (B:273:0x08b9, B:275:0x08c4, B:277:0x08d2, B:279:0x08dc, B:282:0x08f0, B:284:0x08fc, B:286:0x0908, B:288:0x0912, B:290:0x0920, B:292:0x0938, B:296:0x0951, B:298:0x095f, B:299:0x0968, B:301:0x0973, B:303:0x09b6, B:306:0x09c1, B:307:0x09cb, B:308:0x09cc, B:310:0x09d6, B:276:0x08c9), top: B:390:0x08b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x09d6 A[Catch: all -> 0x094a, TRY_LEAVE, TryCatch #5 {all -> 0x094a, blocks: (B:273:0x08b9, B:275:0x08c4, B:277:0x08d2, B:279:0x08dc, B:282:0x08f0, B:284:0x08fc, B:286:0x0908, B:288:0x0912, B:290:0x0920, B:292:0x0938, B:296:0x0951, B:298:0x095f, B:299:0x0968, B:301:0x0973, B:303:0x09b6, B:306:0x09c1, B:307:0x09cb, B:308:0x09cc, B:310:0x09d6, B:276:0x08c9), top: B:390:0x08b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0a3c  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0a47 A[Catch: all -> 0x0a04, TryCatch #1 {all -> 0x0a04, blocks: (B:312:0x09df, B:314:0x09f6, B:318:0x0a07, B:320:0x0a3f, B:322:0x0a47, B:324:0x0a51, B:325:0x0a5b, B:327:0x0a65, B:328:0x0a6f, B:329:0x0a78, B:331:0x0a7e, B:333:0x0ac8, B:335:0x0ada, B:339:0x0af9, B:341:0x0b09, B:338:0x0ae9, B:345:0x0b1c, B:346:0x0b5e, B:347:0x0b69, B:348:0x0b7e, B:350:0x0b84, B:359:0x0bcf, B:360:0x0c1b, B:362:0x0c2c, B:376:0x0c95, B:367:0x0c46, B:368:0x0c49, B:353:0x0b92, B:355:0x0bbc, B:373:0x0c66, B:374:0x0c7f, B:375:0x0c80), top: B:384:0x09df, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0a65 A[Catch: all -> 0x0a04, TryCatch #1 {all -> 0x0a04, blocks: (B:312:0x09df, B:314:0x09f6, B:318:0x0a07, B:320:0x0a3f, B:322:0x0a47, B:324:0x0a51, B:325:0x0a5b, B:327:0x0a65, B:328:0x0a6f, B:329:0x0a78, B:331:0x0a7e, B:333:0x0ac8, B:335:0x0ada, B:339:0x0af9, B:341:0x0b09, B:338:0x0ae9, B:345:0x0b1c, B:346:0x0b5e, B:347:0x0b69, B:348:0x0b7e, B:350:0x0b84, B:359:0x0bcf, B:360:0x0c1b, B:362:0x0c2c, B:376:0x0c95, B:367:0x0c46, B:368:0x0c49, B:353:0x0b92, B:355:0x0bbc, B:373:0x0c66, B:374:0x0c7f, B:375:0x0c80), top: B:384:0x09df, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0a7e A[Catch: all -> 0x0a04, TryCatch #1 {all -> 0x0a04, blocks: (B:312:0x09df, B:314:0x09f6, B:318:0x0a07, B:320:0x0a3f, B:322:0x0a47, B:324:0x0a51, B:325:0x0a5b, B:327:0x0a65, B:328:0x0a6f, B:329:0x0a78, B:331:0x0a7e, B:333:0x0ac8, B:335:0x0ada, B:339:0x0af9, B:341:0x0b09, B:338:0x0ae9, B:345:0x0b1c, B:346:0x0b5e, B:347:0x0b69, B:348:0x0b7e, B:350:0x0b84, B:359:0x0bcf, B:360:0x0c1b, B:362:0x0c2c, B:376:0x0c95, B:367:0x0c46, B:368:0x0c49, B:353:0x0b92, B:355:0x0bbc, B:373:0x0c66, B:374:0x0c7f, B:375:0x0c80), top: B:384:0x09df, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0b14  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0b84 A[Catch: all -> 0x0a04, TryCatch #1 {all -> 0x0a04, blocks: (B:312:0x09df, B:314:0x09f6, B:318:0x0a07, B:320:0x0a3f, B:322:0x0a47, B:324:0x0a51, B:325:0x0a5b, B:327:0x0a65, B:328:0x0a6f, B:329:0x0a78, B:331:0x0a7e, B:333:0x0ac8, B:335:0x0ada, B:339:0x0af9, B:341:0x0b09, B:338:0x0ae9, B:345:0x0b1c, B:346:0x0b5e, B:347:0x0b69, B:348:0x0b7e, B:350:0x0b84, B:359:0x0bcf, B:360:0x0c1b, B:362:0x0c2c, B:376:0x0c95, B:367:0x0c46, B:368:0x0c49, B:353:0x0b92, B:355:0x0bbc, B:373:0x0c66, B:374:0x0c7f, B:375:0x0c80), top: B:384:0x09df, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0c2c A[Catch: all -> 0x0a04, SQLiteException -> 0x0c42, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0c42, blocks: (B:360:0x0c1b, B:362:0x0c2c), top: B:388:0x0c1b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0c44  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0b92 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0338 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036c, B:102:0x03a9, B:104:0x03e5, B:106:0x03ea, B:107:0x0401, B:109:0x040c, B:111:0x0426, B:113:0x042c, B:114:0x0443, B:117:0x0462, B:121:0x0484, B:122:0x049b, B:123:0x04a4, B:126:0x04c1, B:127:0x04d5, B:129:0x04dd, B:131:0x04e7, B:133:0x04ed, B:134:0x04f4, B:136:0x0501, B:138:0x0509, B:140:0x0511, B:142:0x0519, B:143:0x0525, B:144:0x0532, B:150:0x057a, B:151:0x058f, B:153:0x05be, B:156:0x05e8, B:160:0x0638, B:163:0x0666, B:165:0x0695, B:166:0x0698, B:168:0x069e, B:170:0x06a6, B:172:0x06ac, B:174:0x06b4, B:176:0x06ba, B:180:0x06c9, B:183:0x06d8, B:185:0x06e1, B:187:0x06e9, B:190:0x071a, B:192:0x0723, B:196:0x0738, B:201:0x0745, B:236:0x07c0, B:237:0x07c7, B:239:0x07ea, B:242:0x07f3, B:246:0x07fe, B:247:0x0818, B:249:0x081e, B:251:0x0838, B:253:0x0844, B:255:0x0851, B:262:0x0886, B:266:0x0890, B:267:0x0893, B:269:0x08a0, B:270:0x08a3, B:281:0x08e7, B:260:0x0872, B:240:0x07ed, B:204:0x074e, B:208:0x075b, B:212:0x0769, B:216:0x0777, B:220:0x0785, B:224:0x0793, B:228:0x079f, B:232:0x07ad, B:162:0x0659, B:147:0x055f, B:95:0x037e, B:96:0x038a, B:98:0x0390, B:100:0x039e, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032e, B:89:0x0338, B:81:0x02d2, B:82:0x02eb, B:86:0x0313, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:391:0x01cc, inners: #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x037e A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:35:0x01cc, B:38:0x01d9, B:40:0x01e1, B:46:0x01ef, B:91:0x036c, B:102:0x03a9, B:104:0x03e5, B:106:0x03ea, B:107:0x0401, B:109:0x040c, B:111:0x0426, B:113:0x042c, B:114:0x0443, B:117:0x0462, B:121:0x0484, B:122:0x049b, B:123:0x04a4, B:126:0x04c1, B:127:0x04d5, B:129:0x04dd, B:131:0x04e7, B:133:0x04ed, B:134:0x04f4, B:136:0x0501, B:138:0x0509, B:140:0x0511, B:142:0x0519, B:143:0x0525, B:144:0x0532, B:150:0x057a, B:151:0x058f, B:153:0x05be, B:156:0x05e8, B:160:0x0638, B:163:0x0666, B:165:0x0695, B:166:0x0698, B:168:0x069e, B:170:0x06a6, B:172:0x06ac, B:174:0x06b4, B:176:0x06ba, B:180:0x06c9, B:183:0x06d8, B:185:0x06e1, B:187:0x06e9, B:190:0x071a, B:192:0x0723, B:196:0x0738, B:201:0x0745, B:236:0x07c0, B:237:0x07c7, B:239:0x07ea, B:242:0x07f3, B:246:0x07fe, B:247:0x0818, B:249:0x081e, B:251:0x0838, B:253:0x0844, B:255:0x0851, B:262:0x0886, B:266:0x0890, B:267:0x0893, B:269:0x08a0, B:270:0x08a3, B:281:0x08e7, B:260:0x0872, B:240:0x07ed, B:204:0x074e, B:208:0x075b, B:212:0x0769, B:216:0x0777, B:220:0x0785, B:224:0x0793, B:228:0x079f, B:232:0x07ad, B:162:0x0659, B:147:0x055f, B:95:0x037e, B:96:0x038a, B:98:0x0390, B:100:0x039e, B:54:0x020f, B:57:0x021d, B:59:0x0232, B:65:0x024a, B:70:0x027a, B:72:0x0280, B:74:0x028e, B:76:0x029c, B:79:0x02a5, B:87:0x032e, B:89:0x0338, B:81:0x02d2, B:82:0x02eb, B:86:0x0313, B:85:0x02fe, B:68:0x0256, B:69:0x0274), top: B:391:0x01cc, inners: #7, #8, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(f9.v r60, f9.w4 r61) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.g(f9.v, f9.w4):void");
    }

    public final a1 g0() {
        a1 a1Var = this.B;
        P(a1Var);
        return a1Var;
    }

    public final void h(b1 b1Var, com.google.android.gms.internal.measurement.i3 i3Var) {
        p6.c cVar;
        com.google.android.gms.internal.measurement.s3 s3Var;
        h hVar;
        a0().m1();
        i0();
        String strB0 = ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).B0();
        EnumMap enumMap = new EnumMap(f2.class);
        int length = strB0.length();
        int length2 = f2.values().length;
        h hVar2 = h.UNSET;
        int i = 0;
        if (length < length2 || strB0.charAt(0) != '1') {
            cVar = new p6.c(11);
        } else {
            f2[] f2VarArrValues = f2.values();
            int length3 = f2VarArrValues.length;
            int i10 = 0;
            int i11 = 1;
            while (i10 < length3) {
                f2 f2Var = f2VarArrValues[i10];
                int i12 = i11 + 1;
                char cCharAt = strB0.charAt(i11);
                h[] hVarArrValues = h.values();
                int length4 = hVarArrValues.length;
                int i13 = i;
                while (true) {
                    if (i13 >= length4) {
                        hVar = hVar2;
                        break;
                    }
                    hVar = hVarArrValues[i13];
                    if (hVar.f4201v == cCharAt) {
                        break;
                    } else {
                        i13++;
                    }
                }
                enumMap.put(f2Var, hVar);
                i10++;
                i11 = i12;
                i = 0;
            }
            cVar = new p6.c(enumMap);
        }
        String strD = b1Var.D();
        a0().m1();
        i0();
        g2 g2VarA = a(strD);
        EnumMap enumMap2 = g2VarA.f4189a;
        f2 f2Var2 = f2.f4170w;
        d2 d2Var = (d2) enumMap2.get(f2Var2);
        d2 d2Var2 = d2.f4070w;
        if (d2Var == null) {
            d2Var = d2Var2;
        }
        int i14 = g2VarA.f4190b;
        int iOrdinal = d2Var.ordinal();
        h hVar3 = h.REMOTE_ENFORCED_DEFAULT;
        h hVar4 = h.FAILSAFE;
        if (iOrdinal == 1) {
            cVar.B(f2Var2, hVar3);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            cVar.y(f2Var2, i14);
        } else {
            cVar.B(f2Var2, hVar4);
        }
        f2 f2Var3 = f2.f4171x;
        d2 d2Var3 = (d2) enumMap2.get(f2Var3);
        if (d2Var3 != null) {
            d2Var2 = d2Var3;
        }
        int iOrdinal2 = d2Var2.ordinal();
        if (iOrdinal2 == 1) {
            cVar.B(f2Var3, hVar3);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            cVar.y(f2Var3, i14);
        } else {
            cVar.B(f2Var3, hVar4);
        }
        String strD2 = b1Var.D();
        a0().m1();
        i0();
        p pVarN0 = n0(strD2, l0(strD2), a(strD2), cVar);
        String str = pVarN0.f4317d;
        Boolean bool = pVarN0.f4316c;
        o8.u.g(bool);
        boolean zBooleanValue = bool.booleanValue();
        i3Var.b();
        ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).f1(zBooleanValue);
        if (!TextUtils.isEmpty(str)) {
            i3Var.b();
            ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).g1(str);
        }
        a0().m1();
        i0();
        Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).U1()).iterator();
        while (true) {
            if (it.hasNext()) {
                s3Var = (com.google.android.gms.internal.measurement.s3) it.next();
                if ("_npa".equals(s3Var.r())) {
                    break;
                }
            } else {
                s3Var = null;
                break;
            }
        }
        if (s3Var != null) {
            EnumMap enumMap3 = (EnumMap) cVar.f10035w;
            f2 f2Var4 = f2.f4173z;
            h hVar5 = (h) enumMap3.get(f2Var4);
            if (hVar5 == null) {
                hVar5 = hVar2;
            }
            if (hVar5 == hVar2) {
                n nVar = this.f4355x;
                P(nVar);
                t4 t4VarG2 = nVar.g2(b1Var.D(), "_npa");
                h hVar6 = h.MANIFEST;
                h hVar7 = h.API;
                if (t4VarG2 != null) {
                    String str2 = t4VarG2.f4422b;
                    if ("tcf".equals(str2)) {
                        cVar.B(f2Var4, h.TCF);
                    } else if ("app".equals(str2)) {
                        cVar.B(f2Var4, hVar7);
                    } else {
                        cVar.B(f2Var4, hVar6);
                    }
                } else {
                    Boolean boolW = b1Var.w();
                    if (boolW == null || ((boolW.booleanValue() && s3Var.v() != 1) || !(boolW.booleanValue() || s3Var.v() == 0))) {
                        cVar.B(f2Var4, hVar7);
                    } else {
                        cVar.B(f2Var4, hVar6);
                    }
                }
            }
        } else {
            int iA = A(b1Var.D(), cVar);
            com.google.android.gms.internal.measurement.r3 r3VarA = com.google.android.gms.internal.measurement.s3.A();
            r3VarA.b();
            ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).C("_npa");
            A0().getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            r3VarA.b();
            ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).B(jCurrentTimeMillis);
            r3VarA.b();
            ((com.google.android.gms.internal.measurement.s3) r3VarA.f2470w).F(iA);
            com.google.android.gms.internal.measurement.s3 s3Var2 = (com.google.android.gms.internal.measurement.s3) r3VarA.e();
            i3Var.b();
            ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).d0(s3Var2);
            C().J.c("non_personalized_ads(_npa)", Integer.valueOf(iA), "Setting user property");
        }
        String string = cVar.toString();
        i3Var.b();
        ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).e1(string);
        String strD3 = b1Var.D();
        l1 l1Var = this.f4353v;
        l1Var.m1();
        l1Var.s1(strD3);
        com.google.android.gms.internal.measurement.a2 a2VarH1 = l1Var.H1(strD3);
        boolean z10 = a2VarH1 == null || !a2VarH1.s() || a2VarH1.t();
        List listU = i3Var.U();
        for (int i15 = 0; i15 < listU.size(); i15++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.b3) listU.get(i15)).s())) {
                com.google.android.gms.internal.measurement.a3 a3Var = (com.google.android.gms.internal.measurement.a3) ((com.google.android.gms.internal.measurement.b3) listU.get(i15)).i();
                List listH = a3Var.h();
                int i16 = 0;
                while (true) {
                    if (i16 >= listH.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.e3) listH.get(i16)).q())) {
                        String strS = ((com.google.android.gms.internal.measurement.e3) listH.get(i16)).s();
                        if (z10 && strS.length() > 4) {
                            char[] charArray = strS.toCharArray();
                            int i17 = 1;
                            while (true) {
                                if (i17 >= 64) {
                                    i17 = 0;
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i17)) {
                                    break;
                                } else {
                                    i17++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i17 | 1);
                            strS = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
                        d3VarB.h("_tcfd");
                        d3VarB.i(strS);
                        a3Var.b();
                        ((com.google.android.gms.internal.measurement.b3) a3Var.f2470w).A(i16, (com.google.android.gms.internal.measurement.e3) d3VarB.e());
                    } else {
                        i16++;
                    }
                }
                i3Var.W(i15, a3Var);
                return;
            }
        }
    }

    public final u4 h0() {
        r1 r1Var = this.G;
        o8.u.g(r1Var);
        u4 u4Var = r1Var.D;
        r1.e(u4Var);
        return u4Var;
    }

    public final void i(b1 b1Var, com.google.android.gms.internal.measurement.i3 i3Var) {
        Serializable serializableB1;
        a0().m1();
        i0();
        com.google.android.gms.internal.measurement.l2 l2VarO = com.google.android.gms.internal.measurement.o2.O();
        r1 r1Var = b1Var.f4024a;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.m1();
        byte[] bArr = b1Var.H;
        if (bArr != null) {
            try {
                l2VarO = (com.google.android.gms.internal.measurement.l2) a1.Z1(l2VarO, bArr);
            } catch (r5 unused) {
                C().E.b(w0.u1(b1Var.D()), "Failed to parse locally stored ad campaign info. appId");
            }
        }
        Iterator it = i3Var.U().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) it.next();
            if (b3Var.s().equals("_cmp")) {
                com.google.android.gms.internal.measurement.e3 e3VarU1 = a1.u1(b3Var, "gclid");
                Serializable serializableB12 = e3VarU1 == null ? null : a1.B1(e3VarU1);
                if (serializableB12 == null) {
                    serializableB12 = "";
                }
                String str = (String) serializableB12;
                com.google.android.gms.internal.measurement.e3 e3VarU12 = a1.u1(b3Var, "gbraid");
                Serializable serializableB13 = e3VarU12 == null ? null : a1.B1(e3VarU12);
                if (serializableB13 == null) {
                    serializableB13 = "";
                }
                String str2 = (String) serializableB13;
                com.google.android.gms.internal.measurement.e3 e3VarU13 = a1.u1(b3Var, "gad_source");
                Serializable serializableB14 = e3VarU13 == null ? null : a1.B1(e3VarU13);
                String str3 = (String) (serializableB14 != null ? serializableB14 : "");
                String[] strArrSplit = ((String) f0.f4129h1.a(null)).split(",");
                g0();
                HashMap map = new HashMap();
                for (com.google.android.gms.internal.measurement.e3 e3Var : b3Var.p()) {
                    if (Arrays.asList(strArrSplit).contains(e3Var.q()) && (serializableB1 = a1.B1(e3Var)) != null) {
                        map.put(e3Var.q(), serializableB1);
                    }
                }
                if (!map.isEmpty()) {
                    com.google.android.gms.internal.measurement.e3 e3VarU14 = a1.u1(b3Var, "click_timestamp");
                    Serializable serializableB15 = e3VarU14 == null ? null : a1.B1(e3VarU14);
                    long jLongValue = ((Long) (serializableB15 != null ? serializableB15 : 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = b3Var.u();
                    }
                    com.google.android.gms.internal.measurement.e3 e3VarU15 = a1.u1(b3Var, "_cis");
                    if ("referrer API v2".equals(e3VarU15 != null ? a1.B1(e3VarU15) : null)) {
                        if (jLongValue > ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).N()) {
                            if (str.isEmpty()) {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).q();
                            } else {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).p(str);
                            }
                            if (str2.isEmpty()) {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).s();
                            } else {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).r(str2);
                            }
                            if (str3.isEmpty()) {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).u();
                            } else {
                                l2VarO.b();
                                ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).t(str3);
                            }
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).v(jLongValue);
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).x().clear();
                            HashMap mapB = B(b3Var);
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).x().putAll(mapB);
                        }
                    } else if (jLongValue > ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).F()) {
                        if (str.isEmpty()) {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).R();
                        } else {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).Q(str);
                        }
                        if (str2.isEmpty()) {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).T();
                        } else {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).S(str2);
                        }
                        if (str3.isEmpty()) {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).V();
                        } else {
                            l2VarO.b();
                            ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).U(str3);
                        }
                        l2VarO.b();
                        ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).W(jLongValue);
                        l2VarO.b();
                        ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).w().clear();
                        HashMap mapB2 = B(b3Var);
                        l2VarO.b();
                        ((com.google.android.gms.internal.measurement.o2) l2VarO.f2470w).w().putAll(mapB2);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.o2) l2VarO.e()).equals(com.google.android.gms.internal.measurement.o2.P())) {
            com.google.android.gms.internal.measurement.o2 o2Var = (com.google.android.gms.internal.measurement.o2) l2VarO.e();
            i3Var.b();
            ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).k1(o2Var);
        }
        byte[] bArrA = ((com.google.android.gms.internal.measurement.o2) l2VarO.e()).a();
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        p1Var2.m1();
        b1Var.Q |= b1Var.H != bArrA;
        b1Var.H = bArrA;
        if (b1Var.o()) {
            n nVar = this.f4355x;
            P(nVar);
            nVar.p2(b1Var, false);
        }
        if (Z().w1(null, f0.f4126g1)) {
            n nVar2 = this.f4355x;
            P(nVar2);
            nVar2.e2(b1Var.D(), "_lgclid");
        }
    }

    public final void i0() {
        if (!this.H.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final String j(g2 g2Var) {
        if (!g2Var.i(f2.f4171x)) {
            return null;
        }
        byte[] bArr = new byte[16];
        h0().k2().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void j0(w4 w4Var) {
        a0().m1();
        i0();
        String str = w4Var.f4462v;
        o8.u.d(str);
        g2 g2VarC = g2.c(w4Var.S, w4Var.N);
        a(str);
        C().J.c(str, g2VarC, "Setting storage consent for package");
        a0().m1();
        i0();
        this.W.put(str, g2VarC);
        n nVar = this.f4355x;
        P(nVar);
        nVar.H1(str, g2VarC);
    }

    public final void k(ArrayList arrayList) {
        o8.u.b(!arrayList.isEmpty());
        if (this.T != null) {
            C().B.a("Set uploading progress before finishing the previous upload");
        } else {
            this.T = new ArrayList(arrayList);
        }
    }

    public final void k0(w4 w4Var) {
        a0().m1();
        i0();
        String str = w4Var.f4462v;
        o8.u.d(str);
        p pVarB = p.b(w4Var.T);
        C().J.c(str, pVarB, "Setting DMA consent for package");
        a0().m1();
        i0();
        d2 d2VarA = p.c(100, m0(str)).a();
        this.X.put(str, pVarB);
        n nVar = this.f4355x;
        P(nVar);
        o8.u.g(str);
        o8.u.g(pVarB);
        nVar.m1();
        nVar.n1();
        g2 g2VarF1 = nVar.F1(str);
        g2 g2Var = g2.f4188c;
        if (g2VarF1 == g2Var) {
            nVar.H1(str, g2Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", pVarB.f4315b);
        nVar.J1(contentValues);
        d2 d2VarA2 = p.c(100, m0(str)).a();
        a0().m1();
        i0();
        d2 d2Var = d2.f4073z;
        d2 d2Var2 = d2.f4072y;
        boolean z10 = d2VarA == d2Var2 && d2VarA2 == d2Var;
        boolean z11 = d2VarA == d2Var && d2VarA2 == d2Var2;
        if (z10 || z11) {
            C().J.b(str, "Generated _dcu event for");
            Bundle bundle = new Bundle();
            n nVar2 = this.f4355x;
            P(nVar2);
            if (nVar2.q2(b(), str, false, false, false, false).f < Z().u1(str, f0.f4144n0)) {
                bundle.putLong("_r", 1L);
                n nVar3 = this.f4355x;
                P(nVar3);
                C().J.c(str, Long.valueOf(nVar3.q2(b(), str, false, false, true, false).f), "_dcu realtime event count");
            }
            this.f4352e0.A(str, "_dcu", bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ab A[Catch: all -> 0x0028, TryCatch #4 {all -> 0x0028, blocks: (B:3:0x000e, B:5:0x001b, B:8:0x002b, B:10:0x0031, B:11:0x003e, B:13:0x0046, B:14:0x004b, B:16:0x0056, B:17:0x0063, B:19:0x006e, B:20:0x007e, B:22:0x00a8, B:24:0x00ae, B:25:0x00b1, B:27:0x00ca, B:28:0x00df, B:30:0x00f0, B:32:0x00f6, B:35:0x010b, B:45:0x012a, B:47:0x012f, B:48:0x0132, B:49:0x0133, B:50:0x0138, B:55:0x017d, B:71:0x01a5, B:73:0x01ab, B:75:0x01b6, B:79:0x01c1, B:80:0x01c4, B:33:0x00fb, B:37:0x010f, B:42:0x0117), top: B:91:0x000e, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [f9.q4] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.l():void");
    }

    public final p l0(String str) {
        a0().m1();
        i0();
        HashMap map = this.X;
        p pVar = (p) map.get(str);
        if (pVar != null) {
            return pVar;
        }
        n nVar = this.f4355x;
        P(nVar);
        o8.u.g(str);
        nVar.m1();
        nVar.n1();
        p pVarB = p.b(nVar.I1("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
        map.put(str, pVarB);
        return pVarB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f A[PHI: r0 r11 r22 r24
      0x006f: PHI (r0v114 java.util.List) = (r0v8 java.util.List), (r0v136 java.util.List) binds: [B:108:0x0225, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r11v47 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v49 android.database.Cursor) binds: [B:108:0x0225, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r22v28 ??) = (r22v40 ??), (r22v41 ??) binds: [B:108:0x0225, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x006f: PHI (r24v7 long) = (r24v2 long), (r24v8 long) binds: [B:108:0x0225, B:16:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x07b4  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0808  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x084a  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x08a8 A[LOOP:7: B:345:0x08a2->B:347:0x08a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x08e8  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x08eb  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x09fb  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x09fe  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0a8b  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x07fc A[EDGE_INSN: B:447:0x07fc->B:317:0x07fc BREAK  A[LOOP:4: B:263:0x0653->B:316:0x07ee], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x07ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x085f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:484:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:489:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v27 */
    /* JADX WARN: Type inference failed for: r22v28 */
    /* JADX WARN: Type inference failed for: r22v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v31 */
    /* JADX WARN: Type inference failed for: r22v32 */
    /* JADX WARN: Type inference failed for: r22v33 */
    /* JADX WARN: Type inference failed for: r22v34 */
    /* JADX WARN: Type inference failed for: r22v35 */
    /* JADX WARN: Type inference failed for: r22v36 */
    /* JADX WARN: Type inference failed for: r22v37 */
    /* JADX WARN: Type inference failed for: r22v38 */
    /* JADX WARN: Type inference failed for: r22v39 */
    /* JADX WARN: Type inference failed for: r22v40 */
    /* JADX WARN: Type inference failed for: r22v41 */
    /* JADX WARN: Type inference failed for: r22v42 */
    /* JADX WARN: Type inference failed for: r22v43 */
    /* JADX WARN: Type inference failed for: r22v44 */
    /* JADX WARN: Type inference failed for: r22v45 */
    /* JADX WARN: Type inference failed for: r22v46 */
    /* JADX WARN: Type inference failed for: r22v47 */
    /* JADX WARN: Type inference failed for: r33v0, types: [f9.q4] */
    /* JADX WARN: Type inference failed for: r8v64, types: [f9.h4] */
    /* JADX WARN: Type inference failed for: r8v65 */
    /* JADX WARN: Type inference failed for: r8v86 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(java.lang.String r34, long r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.m(java.lang.String, long):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final Bundle m0(String str) {
        a0().m1();
        i0();
        l1 l1Var = this.f4353v;
        P(l1Var);
        if (l1Var.H1(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        g2 g2VarA = a(str);
        Bundle bundle2 = new Bundle();
        Iterator it = g2VarA.f4189a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((d2) entry.getValue()).ordinal();
            String str2 = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str2 != null) {
                bundle2.putString(((f2) entry.getKey()).f4174v, str2);
            }
        }
        bundle.putAll(bundle2);
        p pVarN0 = n0(str, l0(str), g2VarA, new p6.c(11));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry2 : pVarN0.f4318e.entrySet()) {
            int iOrdinal2 = ((d2) entry2.getValue()).ordinal();
            String str3 = iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : "granted" : "denied";
            if (str3 != null) {
                bundle3.putString(((f2) entry2.getKey()).f4174v, str3);
            }
        }
        Boolean bool = pVarN0.f4316c;
        if (bool != null) {
            bundle3.putString("is_dma_region", bool.toString());
        }
        String str4 = pVarN0.f4317d;
        if (str4 != null) {
            bundle3.putString("cps_display_str", str4);
        }
        bundle.putAll(bundle3);
        n nVar = this.f4355x;
        P(nVar);
        t4 t4VarG2 = nVar.g2(str, "_npa");
        bundle.putString("ad_personalization", 1 != (t4VarG2 != null ? t4VarG2.f4425e.equals(1L) : A(str, new p6.c(11))) ? "granted" : "denied");
        return bundle;
    }

    public final boolean n(String str, String str2) {
        n nVar = this.f4355x;
        P(nVar);
        b1 b1VarO2 = nVar.o2(str);
        HashMap map = this.Z;
        if (b1VarO2 != null && h0().N1(str, b1VarO2.C())) {
            map.remove(str2);
            return true;
        }
        p4 p4Var = (p4) map.get(str2);
        if (p4Var != null) {
            p4Var.f4329a.A0().getClass();
            if (System.currentTimeMillis() < p4Var.f4331c) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f9.p n0(java.lang.String r12, f9.p r13, f9.g2 r14, p6.c r15) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.n0(java.lang.String, f9.p, f9.g2, p6.c):f9.p");
    }

    public final void o(String str) {
        a0().m1();
        i0();
        this.Q = true;
        try {
            r1 r1Var = this.G;
            r1Var.getClass();
            Boolean bool = r1Var.j().A;
            if (bool == null) {
                C().E.a("Upload data called on the client side before use of service was decided");
            } else if (bool.booleanValue()) {
                C().B.a("Upload called in the client side when service should be used");
            } else if (this.J > 0) {
                J();
            } else {
                a1 a1Var = this.f4354w;
                P(a1Var);
                if (a1Var.G1()) {
                    n nVar = this.f4355x;
                    P(nVar);
                    if (nVar.s1(str)) {
                        n nVar2 = this.f4355x;
                        P(nVar2);
                        o8.u.d(str);
                        nVar2.m1();
                        nVar2.n1();
                        List listR1 = nVar2.r1(str, j4.a(e3.f4103x), 1);
                        r4 r4Var = listR1.isEmpty() ? null : (r4) listR1.get(0);
                        if (r4Var != null) {
                            com.google.android.gms.internal.measurement.h3 h3Var = r4Var.f4374b;
                            C().J.d("[sgtm] Uploading data from upload queue. appId, type, url", str, r4Var.f4377e, r4Var.f4375c);
                            byte[] bArrA = h3Var.a();
                            if (Log.isLoggable(C().w1(), 2)) {
                                a1 a1Var2 = this.B;
                                P(a1Var2);
                                C().J.d("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrA.length), a1Var2.P1(h3Var));
                            }
                            m4 m4Var = new m4(r4Var.f4375c, r4Var.f4376d, r4Var.f4377e, null);
                            this.P = true;
                            a1 a1Var3 = this.f4354w;
                            P(a1Var3);
                            a1Var3.L1(str, m4Var, h3Var, new androidx.emoji2.text.v(this, str, (Object) r4Var, 14));
                        }
                    } else {
                        C().J.b(str, "[sgtm] Upload queue has no batches for appId");
                    }
                } else {
                    C().J.a("Network not connected, ignoring upload request");
                    J();
                }
            }
            this.Q = false;
            K();
        } catch (Throwable th) {
            this.Q = false;
            K();
            throw th;
        }
    }

    public final void p(String str, boolean z10, Long l10, Long l11) {
        n nVar = this.f4355x;
        P(nVar);
        b1 b1VarO2 = nVar.o2(str);
        if (b1VarO2 != null) {
            r1 r1Var = b1VarO2.f4024a;
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.m1();
            b1VarO2.Q |= b1VarO2.f4046y != z10;
            b1VarO2.f4046y = z10;
            p1 p1Var2 = r1Var.B;
            r1.g(p1Var2);
            p1Var2.m1();
            b1VarO2.Q |= !Objects.equals(b1VarO2.f4047z, l10);
            b1VarO2.f4047z = l10;
            p1 p1Var3 = r1Var.B;
            r1.g(p1Var3);
            p1Var3.m1();
            b1VarO2.Q |= !Objects.equals(b1VarO2.A, l11);
            b1VarO2.A = l11;
            if (b1VarO2.o()) {
                n nVar2 = this.f4355x;
                P(nVar2);
                nVar2.p2(b1VarO2, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(com.google.android.gms.internal.measurement.i3 r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.q(com.google.android.gms.internal.measurement.i3, java.lang.String):void");
    }

    public final void r(com.google.android.gms.internal.measurement.i3 i3Var, b7.d dVar) {
        String strF2;
        String strF22;
        for (int i = 0; i < i3Var.V(); i++) {
            com.google.android.gms.internal.measurement.a3 a3Var = (com.google.android.gms.internal.measurement.a3) ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).T1(i).i();
            Iterator it = a3Var.h().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.e3) it.next()).q())) {
                    if (((com.google.android.gms.internal.measurement.j3) dVar.f1826w).G0() >= Z().u1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f0.f4142m0)) {
                        int iU1 = Z().u1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f0.f4167z0);
                        LinkedList linkedList = this.L;
                        a1 a1Var = this.B;
                        if (iU1 > 0) {
                            n nVar = this.f4355x;
                            P(nVar);
                            if (nVar.q2(b(), ((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), false, false, false, true).f4232g > iU1) {
                                com.google.android.gms.internal.measurement.d3 d3VarB = com.google.android.gms.internal.measurement.e3.B();
                                d3VarB.h("_tnr");
                                d3VarB.j(1L);
                                a3Var.k((com.google.android.gms.internal.measurement.e3) d3VarB.e());
                            } else {
                                if (Z().w1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f0.S0)) {
                                    strF22 = h0().f2();
                                    com.google.android.gms.internal.measurement.d3 d3VarB2 = com.google.android.gms.internal.measurement.e3.B();
                                    d3VarB2.h("_tu");
                                    d3VarB2.i(strF22);
                                    a3Var.k((com.google.android.gms.internal.measurement.e3) d3VarB2.e());
                                } else {
                                    strF22 = null;
                                }
                                com.google.android.gms.internal.measurement.d3 d3VarB3 = com.google.android.gms.internal.measurement.e3.B();
                                d3VarB3.h("_tr");
                                d3VarB3.j(1L);
                                a3Var.k((com.google.android.gms.internal.measurement.e3) d3VarB3.e());
                                P(a1Var);
                                f4 f4VarN1 = a1Var.N1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), i3Var, a3Var, strF22);
                                if (f4VarN1 != null) {
                                    C().J.c(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f4VarN1.f4180v, "Generated trigger URI. appId, uri");
                                    n nVar2 = this.f4355x;
                                    P(nVar2);
                                    nVar2.G1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f4VarN1);
                                    if (!linkedList.contains(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p())) {
                                        linkedList.add(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p());
                                    }
                                }
                            }
                        } else {
                            if (Z().w1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f0.S0)) {
                                strF2 = h0().f2();
                                com.google.android.gms.internal.measurement.d3 d3VarB4 = com.google.android.gms.internal.measurement.e3.B();
                                d3VarB4.h("_tu");
                                d3VarB4.i(strF2);
                                a3Var.k((com.google.android.gms.internal.measurement.e3) d3VarB4.e());
                            } else {
                                strF2 = null;
                            }
                            com.google.android.gms.internal.measurement.d3 d3VarB5 = com.google.android.gms.internal.measurement.e3.B();
                            d3VarB5.h("_tr");
                            d3VarB5.j(1L);
                            a3Var.k((com.google.android.gms.internal.measurement.e3) d3VarB5.e());
                            P(a1Var);
                            f4 f4VarN12 = a1Var.N1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), i3Var, a3Var, strF2);
                            if (f4VarN12 != null) {
                                C().J.c(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f4VarN12.f4180v, "Generated trigger URI. appId, uri");
                                n nVar3 = this.f4355x;
                                P(nVar3);
                                nVar3.G1(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p(), f4VarN12);
                                if (!linkedList.contains(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p())) {
                                    linkedList.add(((com.google.android.gms.internal.measurement.j3) dVar.f1826w).p());
                                }
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) a3Var.e();
                    i3Var.b();
                    ((com.google.android.gms.internal.measurement.j3) i3Var.f2470w).X(i, b3Var);
                }
            }
        }
    }

    public final void s(String str, com.google.android.gms.internal.measurement.d3 d3Var, Bundle bundle, String str2) {
        int iMax;
        List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si"));
        if (u4.L1(((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).q()) || u4.L1(str)) {
            g gVarZ = Z();
            gVarZ.getClass();
            iMax = Math.max(Math.max(Math.min(gVarZ.u1(str2, f0.f4130i0), 500), 100), 256);
        } else {
            g gVarZ2 = Z();
            gVarZ2.getClass();
            iMax = Math.max(Math.min(gVarZ2.u1(str2, f0.f4130i0), 500), 100);
        }
        long j4 = iMax;
        long jCodePointCount = ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).s().codePointCount(0, ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).s().length());
        h0();
        String strQ = ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).q();
        Z();
        String strR1 = u4.r1(strQ, true, 40);
        if (jCodePointCount <= j4 || listUnmodifiableList.contains(((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).q())) {
            return;
        }
        if ("_ev".equals(((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).q())) {
            h0();
            String strS = ((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).s();
            g gVarZ3 = Z();
            gVarZ3.getClass();
            bundle.putString("_ev", u4.r1(strS, true, Math.max(Math.max(Math.min(gVarZ3.u1(str2, f0.f4130i0), 500), 100), 256)));
            return;
        }
        C().G.c(strR1, Long.valueOf(jCodePointCount), "Param value is too long; discarded. Name, value length");
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strR1);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(((com.google.android.gms.internal.measurement.e3) d3Var.f2470w).q());
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0153 A[EDGE_INSN: B:105:0x0153->B:52:0x0153 BREAK  A[LOOP:0: B:33:0x00f5->B:107:0x00f5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: all -> 0x0018, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9, B:95:0x0266), top: B:104:0x0015, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f A[Catch: all -> 0x0018, PHI: r0
      0x008f: PHI (r0v2 int) = (r0v0 int), (r0v36 int) binds: [B:9:0x0025, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x0018, blocks: (B:4:0x0015, B:8:0x001d, B:16:0x0032, B:21:0x0082, B:20:0x0070, B:22:0x008f, B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9, B:95:0x0266), top: B:104:0x0015, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff A[Catch: all -> 0x0150, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015e A[Catch: all -> 0x0150, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b8 A[Catch: all -> 0x0150, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #1 {all -> 0x0150, blocks: (B:32:0x00ec, B:33:0x00f5, B:36:0x00ff, B:39:0x0113, B:41:0x011f, B:42:0x0121, B:46:0x0138, B:48:0x0142, B:52:0x0153, B:53:0x0158, B:55:0x015e, B:57:0x0171, B:59:0x0188, B:60:0x018a, B:62:0x019c, B:64:0x01b8, B:66:0x01dc, B:67:0x01eb, B:69:0x01f2, B:70:0x01fa, B:73:0x0209, B:75:0x020d, B:78:0x0214, B:79:0x0215), top: B:102:0x00ec, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0230 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0241 A[Catch: all -> 0x0018, SQLiteException -> 0x00b7, TryCatch #2 {SQLiteException -> 0x00b7, blocks: (B:24:0x00a4, B:27:0x00ba, B:29:0x00c8, B:31:0x00e4, B:80:0x021d, B:82:0x0230, B:84:0x023b, B:92:0x025a, B:86:0x0241, B:88:0x024a, B:90:0x0250, B:91:0x0254, B:93:0x025d, B:94:0x0265, B:30:0x00d9), top: B:103:0x00a4, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(boolean r18, int r19, java.lang.Throwable r20, byte[] r21, java.lang.String r22, java.util.List r23) {
        /*
            Method dump skipped, instruction units count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.t(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    public final void u(b1 b1Var) {
        v.e eVar;
        v.e eVar2;
        a0().m1();
        if (TextUtils.isEmpty(b1Var.G())) {
            String strD = b1Var.D();
            o8.u.g(strD);
            v(strD, 204, null, null, null);
            return;
        }
        String strD2 = b1Var.D();
        o8.u.g(strD2);
        C().J.b(strD2, "Fetching remote configuration");
        l1 l1Var = this.f4353v;
        P(l1Var);
        com.google.android.gms.internal.measurement.f2 f2VarY1 = l1Var.y1(strD2);
        P(l1Var);
        l1Var.m1();
        String str = (String) l1Var.I.get(strD2);
        if (f2VarY1 != null) {
            if (TextUtils.isEmpty(str)) {
                eVar2 = null;
            } else {
                eVar2 = new v.e(0);
                eVar2.put("If-Modified-Since", str);
            }
            P(l1Var);
            l1Var.m1();
            String str2 = (String) l1Var.J.get(strD2);
            if (!TextUtils.isEmpty(str2)) {
                if (eVar2 == null) {
                    eVar2 = new v.e(0);
                }
                eVar2.put("If-None-Match", str2);
            }
            eVar = eVar2;
        } else {
            eVar = null;
        }
        this.O = true;
        a1 a1Var = this.f4354w;
        P(a1Var);
        pc.c cVar = new pc.c(this);
        r1 r1Var = (r1) a1Var.f307w;
        a1Var.m1();
        a1Var.n1();
        n4 n4Var = a1Var.f4215x.E;
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) f0.f.a(null)).encodedAuthority((String) f0.f4124g.a(null)).path("config/app/".concat(String.valueOf(b1Var.G()))).appendQueryParameter("platform", "android");
        ((r1) n4Var.f307w).f4366y.r1();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005L)).appendQueryParameter("runtime_version", "0");
        String string = builder.build().toString();
        try {
            URL url = new URI(string).toURL();
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.y1(new z0(a1Var, b1Var.D(), url, (byte[]) null, eVar, cVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.c(w0.u1(b1Var.D()), string, "Failed to parse config URL. Not fetching. appId");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015a A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:8:0x0030, B:18:0x004e, B:55:0x015d, B:26:0x006c, B:31:0x00c8, B:30:0x00b6, B:32:0x00cd, B:36:0x00de, B:40:0x00f4, B:42:0x010c, B:44:0x0127, B:46:0x0130, B:48:0x0136, B:49:0x013a, B:51:0x0143, B:53:0x0152, B:54:0x015a, B:43:0x0118, B:37:0x00e5, B:39:0x00ee), top: B:64:0x0030, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(java.lang.String r10, int r11, java.lang.Throwable r12, byte[] r13, java.util.Map r14) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.q4.v(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void w() {
        a0().m1();
        i0();
        if (this.I) {
            return;
        }
        this.I = true;
        a0().m1();
        FileLock fileLock = this.R;
        r1 r1Var = this.G;
        if (fileLock == null || !fileLock.isValid()) {
            ((r1) this.f4355x.f307w).getClass();
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(r1Var.f4363v.getFilesDir(), "google_app_measurement.db").getPath()), "rw").getChannel();
                this.S = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.R = fileLockTryLock;
                if (fileLockTryLock == null) {
                    C().B.a("Storage concurrent data access panic");
                    return;
                }
                C().J.a("Storage concurrent access okay");
            } catch (FileNotFoundException e9) {
                C().B.b(e9, "Failed to acquire storage lock");
                return;
            } catch (IOException e10) {
                C().B.b(e10, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e11) {
                C().E.b(e11, "Storage lock already acquired");
                return;
            }
        } else {
            C().J.a("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.S;
        a0().m1();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            C().B.a("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i10 = fileChannel.read(byteBufferAllocate);
                if (i10 == 4) {
                    byteBufferAllocate.flip();
                    i = byteBufferAllocate.getInt();
                } else if (i10 != -1) {
                    C().E.b(Integer.valueOf(i10), "Unexpected data length. Bytes read");
                }
            } catch (IOException e12) {
                C().B.b(e12, "Failed to read from channel");
            }
        }
        n0 n0VarL = r1Var.l();
        n0VarL.n1();
        int i11 = n0VarL.A;
        a0().m1();
        if (i > i11) {
            C().B.c(Integer.valueOf(i), Integer.valueOf(i11), "Panic: can't downgrade version. Previous, current version");
            return;
        }
        if (i < i11) {
            FileChannel fileChannel2 = this.S;
            a0().m1();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                C().B.a("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i11);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        C().B.b(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    C().J.c(Integer.valueOf(i), Integer.valueOf(i11), "Storage version upgraded. Previous, current version");
                    return;
                } catch (IOException e13) {
                    C().B.b(e13, "Failed to write to channel");
                }
            }
            C().B.c(Integer.valueOf(i), Integer.valueOf(i11), "Storage version upgrade failed. Previous, current version");
        }
    }
}
