package k8;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.r5;
import com.google.android.gms.internal.measurement.s8;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x3 implements w1 {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static volatile x3 f7542b0;
    public final s0 A;
    public s0 B;
    public j3 C;
    public a1 E;
    public final k1 F;
    public boolean H;
    public long I;
    public ArrayList J;
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public FileLock Q;
    public FileChannel R;
    public ArrayList S;
    public ArrayList T;
    public final HashMap V;
    public final HashMap W;
    public final HashMap X;
    public w2 Y;
    public String Z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d1 f7544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s0 f7545v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i f7546w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public w0 f7547x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public s3 f7548y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public i4 f7549z;
    public boolean G = false;
    public final HashSet K = new HashSet();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final rc.b f7543a0 = new rc.b(20, this);
    public long U = -1;
    public final v3 D = new v3(this);

    public x3(u5.c cVar) {
        this.F = k1.c((Context) cVar.f12782v, null, null);
        s0 s0Var = new s0(this, 2);
        s0Var.u1();
        this.A = s0Var;
        s0 s0Var2 = new s0(this, 0);
        s0Var2.u1();
        this.f7545v = s0Var2;
        d1 d1Var = new d1(this);
        d1Var.u1();
        this.f7544u = d1Var;
        this.V = new HashMap();
        this.W = new HashMap();
        this.X = new HashMap();
        x().y1(new androidx.fragment.app.e(this, cVar));
    }

    public static Boolean Y(a4 a4Var) {
        Boolean bool = a4Var.L;
        String str = a4Var.Z;
        if (!TextUtils.isEmpty(str)) {
            int i = b4.f7101a[((b2) u5.c.q(str).f12782v).ordinal()];
            if (i == 1) {
                return null;
            }
            if (i == 2) {
                return Boolean.FALSE;
            }
            if (i == 3) {
                return Boolean.TRUE;
            }
            if (i == 4) {
                return null;
            }
        }
        return bool;
    }

    public static boolean a0(a4 a4Var) {
        return (TextUtils.isEmpty(a4Var.f7077v) && TextUtils.isEmpty(a4Var.K)) ? false : true;
    }

    public static String f(String str, Map map) {
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

    public static x3 k(Context context) {
        t7.v.h(context);
        t7.v.h(context.getApplicationContext());
        if (f7542b0 == null) {
            synchronized (x3.class) {
                try {
                    if (f7542b0 == null) {
                        f7542b0 = new x3(new u5.c(context, 26));
                    }
                } finally {
                }
            }
        }
        return f7542b0;
    }

    public static void l(com.google.android.gms.internal.measurement.e3 e3Var, int i, String str) {
        List listM = e3Var.m();
        for (int i10 = 0; i10 < listM.size(); i10++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.i3) listM.get(i10)).C())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.h3 h3VarB = com.google.android.gms.internal.measurement.i3.B();
        h3VarB.h("_err");
        h3VarB.g(i);
        com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) h3VarB.c();
        com.google.android.gms.internal.measurement.h3 h3VarB2 = com.google.android.gms.internal.measurement.i3.B();
        h3VarB2.h("_ev");
        h3VarB2.i(str);
        com.google.android.gms.internal.measurement.i3 i3Var2 = (com.google.android.gms.internal.measurement.i3) h3VarB2.c();
        e3Var.h(i3Var);
        e3Var.h(i3Var2);
    }

    public static void m(com.google.android.gms.internal.measurement.e3 e3Var, String str) {
        List listM = e3Var.m();
        for (int i = 0; i < listM.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.i3) listM.get(i)).C())) {
                e3Var.e();
                com.google.android.gms.internal.measurement.f3.p(i, (com.google.android.gms.internal.measurement.f3) e3Var.f3052v);
                return;
            }
        }
    }

    public static void y(t3 t3Var) {
        if (t3Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (!t3Var.f7433x) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(t3Var.getClass())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[Catch: all -> 0x0018, SQLiteException -> 0x00d1, TryCatch #4 {SQLiteException -> 0x00d1, blocks: (B:29:0x00be, B:32:0x00d4, B:34:0x00e2, B:36:0x0102, B:68:0x01ab, B:70:0x01be, B:72:0x01c4, B:81:0x01f3, B:73:0x01c8, B:75:0x01d4, B:77:0x01dd, B:79:0x01e8, B:80:0x01ec, B:82:0x01f6, B:83:0x01fe, B:35:0x00f7), top: B:95:0x00be, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7 A[Catch: all -> 0x0018, SQLiteException -> 0x00d1, TryCatch #4 {SQLiteException -> 0x00d1, blocks: (B:29:0x00be, B:32:0x00d4, B:34:0x00e2, B:36:0x0102, B:68:0x01ab, B:70:0x01be, B:72:0x01c4, B:81:0x01f3, B:73:0x01c8, B:75:0x01d4, B:77:0x01dd, B:79:0x01e8, B:80:0x01ec, B:82:0x01f6, B:83:0x01fe, B:35:0x00f7), top: B:95:0x00be, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:37:0x010a, B:39:0x0116, B:40:0x011a, B:42:0x0120, B:44:0x013a, B:45:0x013c, B:48:0x0148, B:50:0x0151, B:51:0x0159, B:52:0x0174, B:55:0x0181, B:56:0x0188, B:58:0x018a, B:59:0x0195, B:61:0x0197, B:63:0x019b, B:66:0x01a2, B:67:0x01a3), top: B:91:0x010a, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0151 A[Catch: all -> 0x0145, TRY_LEAVE, TryCatch #1 {all -> 0x0145, blocks: (B:37:0x010a, B:39:0x0116, B:40:0x011a, B:42:0x0120, B:44:0x013a, B:45:0x013c, B:48:0x0148, B:50:0x0151, B:51:0x0159, B:52:0x0174, B:55:0x0181, B:56:0x0188, B:58:0x018a, B:59:0x0195, B:61:0x0197, B:63:0x019b, B:66:0x01a2, B:67:0x01a3), top: B:91:0x010a, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c8 A[Catch: all -> 0x0018, SQLiteException -> 0x00d1, TryCatch #4 {SQLiteException -> 0x00d1, blocks: (B:29:0x00be, B:32:0x00d4, B:34:0x00e2, B:36:0x0102, B:68:0x01ab, B:70:0x01be, B:72:0x01c4, B:81:0x01f3, B:73:0x01c8, B:75:0x01d4, B:77:0x01dd, B:79:0x01e8, B:80:0x01ec, B:82:0x01f6, B:83:0x01fe, B:35:0x00f7), top: B:95:0x00be, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d4 A[Catch: all -> 0x0018, SQLiteException -> 0x00d1, TryCatch #4 {SQLiteException -> 0x00d1, blocks: (B:29:0x00be, B:32:0x00d4, B:34:0x00e2, B:36:0x0102, B:68:0x01ab, B:70:0x01be, B:72:0x01c4, B:81:0x01f3, B:73:0x01c8, B:75:0x01d4, B:77:0x01dd, B:79:0x01e8, B:80:0x01ec, B:82:0x01f6, B:83:0x01fe, B:35:0x00f7), top: B:95:0x00be, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ec A[Catch: all -> 0x0018, SQLiteException -> 0x00d1, TryCatch #4 {SQLiteException -> 0x00d1, blocks: (B:29:0x00be, B:32:0x00d4, B:34:0x00e2, B:36:0x0102, B:68:0x01ab, B:70:0x01be, B:72:0x01c4, B:81:0x01f3, B:73:0x01c8, B:75:0x01d4, B:77:0x01dd, B:79:0x01e8, B:80:0x01ec, B:82:0x01f6, B:83:0x01fe, B:35:0x00f7), top: B:95:0x00be, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(boolean r17, int r18, java.lang.Throwable r19, byte[] r20, java.lang.String r21, java.util.List r22) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.A(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    public final boolean B(com.google.android.gms.internal.measurement.e3 e3Var, com.google.android.gms.internal.measurement.e3 e3Var2) {
        t7.v.a("_e".equals(e3Var.l()));
        b0();
        com.google.android.gms.internal.measurement.i3 i3VarC1 = s0.C1((com.google.android.gms.internal.measurement.f3) e3Var.c(), "_sc");
        String strD = i3VarC1 == null ? null : i3VarC1.D();
        b0();
        com.google.android.gms.internal.measurement.i3 i3VarC12 = s0.C1((com.google.android.gms.internal.measurement.f3) e3Var2.c(), "_pc");
        String strD2 = i3VarC12 != null ? i3VarC12.D() : null;
        if (strD2 == null || !strD2.equals(strD)) {
            return false;
        }
        t7.v.a("_e".equals(e3Var.l()));
        b0();
        com.google.android.gms.internal.measurement.i3 i3VarC13 = s0.C1((com.google.android.gms.internal.measurement.f3) e3Var.c(), "_et");
        if (i3VarC13 == null || !i3VarC13.H() || i3VarC13.z() <= 0) {
            return true;
        }
        long jZ = i3VarC13.z();
        b0();
        com.google.android.gms.internal.measurement.i3 i3VarC14 = s0.C1((com.google.android.gms.internal.measurement.f3) e3Var2.c(), "_et");
        if (i3VarC14 != null && i3VarC14.z() > 0) {
            jZ += i3VarC14.z();
        }
        b0();
        s0.O1(e3Var2, "_et", Long.valueOf(jZ));
        b0();
        s0.O1(e3Var, "_fr", 1L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05e6 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06bc A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x06f8 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x074e A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x08ce A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0f2f A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0f52 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x11dd A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a A[Catch: all -> 0x0095, SQLiteException -> 0x0120, TRY_LEAVE, TryCatch #3 {all -> 0x0095, blocks: (B:20:0x0076, B:26:0x0084, B:27:0x0088, B:51:0x00e8, B:53:0x010a, B:58:0x0123, B:59:0x0127, B:60:0x0137, B:62:0x013d, B:63:0x014e, B:65:0x0158, B:68:0x016e, B:70:0x018e, B:74:0x01a5, B:75:0x01ae, B:77:0x01b9, B:83:0x01f8, B:82:0x01e7, B:67:0x0167, B:88:0x0203, B:91:0x0218, B:46:0x00d6, B:50:0x00e1), top: B:572:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:563:0x133b A[Catch: all -> 0x0081, TRY_ENTER, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0123 A[Catch: all -> 0x0095, SQLiteException -> 0x0120, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0095, blocks: (B:20:0x0076, B:26:0x0084, B:27:0x0088, B:51:0x00e8, B:53:0x010a, B:58:0x0123, B:59:0x0127, B:60:0x0137, B:62:0x013d, B:63:0x014e, B:65:0x0158, B:68:0x016e, B:70:0x018e, B:74:0x01a5, B:75:0x01ae, B:77:0x01b9, B:83:0x01f8, B:82:0x01e7, B:67:0x0167, B:88:0x0203, B:91:0x0218, B:46:0x00d6, B:50:0x00e1), top: B:572:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x022b A[Catch: all -> 0x0081, TRY_ENTER, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0015, B:22:0x007c, B:94:0x022e, B:96:0x0234, B:99:0x023c, B:100:0x0257, B:103:0x026f, B:106:0x029f, B:108:0x02dc, B:111:0x02f5, B:113:0x02ff, B:278:0x0890, B:116:0x032c, B:118:0x0342, B:121:0x0365, B:123:0x036f, B:125:0x037f, B:127:0x038d, B:129:0x039d, B:130:0x03a8, B:131:0x03ab, B:133:0x03c1, B:187:0x05e6, B:188:0x05f2, B:191:0x05fe, B:197:0x0621, B:194:0x0610, B:200:0x0629, B:202:0x0635, B:204:0x0641, B:218:0x0689, B:221:0x06b0, B:223:0x06bc, B:226:0x06cd, B:228:0x06de, B:230:0x06ec, B:245:0x0744, B:247:0x074e, B:248:0x075a, B:250:0x0764, B:252:0x0774, B:254:0x077e, B:255:0x0791, B:257:0x0797, B:258:0x07b2, B:260:0x07b8, B:261:0x07d6, B:262:0x07e3, B:266:0x080e, B:263:0x07eb, B:265:0x07f9, B:267:0x081a, B:268:0x083b, B:270:0x0841, B:272:0x0854, B:273:0x0861, B:275:0x0868, B:277:0x087a, B:233:0x06f8, B:235:0x0704, B:238:0x0717, B:240:0x0728, B:242:0x0736, B:210:0x0666, B:214:0x0679, B:216:0x067f, B:219:0x06a7, B:136:0x03d7, B:142:0x03ed, B:145:0x03fb, B:147:0x0409, B:151:0x045d, B:148:0x042d, B:150:0x043d, B:155:0x046a, B:158:0x049b, B:159:0x04c3, B:161:0x04fd, B:163:0x0503, B:166:0x050f, B:168:0x0544, B:169:0x0561, B:171:0x056b, B:173:0x057b, B:178:0x0594, B:174:0x0584, B:182:0x059d, B:184:0x05aa, B:185:0x05cb, B:281:0x08a9, B:283:0x08bb, B:285:0x08c4, B:297:0x08f8, B:287:0x08ce, B:289:0x08d7, B:291:0x08dd, B:294:0x08e9, B:296:0x08f1, B:298:0x08fb, B:299:0x0907, B:302:0x090f, B:304:0x0921, B:305:0x092c, B:307:0x0934, B:311:0x0962, B:313:0x097e, B:315:0x0993, B:317:0x09a2, B:319:0x09be, B:320:0x09d0, B:321:0x09d3, B:322:0x09ef, B:324:0x09f5, B:326:0x0a0d, B:327:0x0a1b, B:329:0x0a2b, B:330:0x0a39, B:331:0x0a3c, B:334:0x0a52, B:336:0x0a95, B:338:0x0a9b, B:344:0x0ac6, B:346:0x0acc, B:347:0x0aea, B:349:0x0af0, B:339:0x0aab, B:341:0x0ab1, B:343:0x0ab7, B:350:0x0b04, B:353:0x0b1d, B:355:0x0b39, B:361:0x0b4d, B:363:0x0b5f, B:366:0x0b6a, B:368:0x0b70, B:369:0x0b86, B:371:0x0b8c, B:373:0x0b9c, B:375:0x0bb8, B:378:0x0bd4, B:380:0x0bfb, B:396:0x0d29, B:398:0x0d35, B:381:0x0c14, B:383:0x0c28, B:385:0x0c45, B:387:0x0c6c, B:388:0x0c9d, B:390:0x0cb3, B:392:0x0cd0, B:394:0x0cf7, B:399:0x0d3b, B:401:0x0d4c, B:403:0x0de7, B:405:0x0df9, B:406:0x0e0c, B:409:0x0e14, B:412:0x0e32, B:414:0x0e4b, B:416:0x0e60, B:418:0x0e65, B:420:0x0e69, B:422:0x0e6d, B:424:0x0e77, B:426:0x0e82, B:428:0x0e86, B:430:0x0e8c, B:432:0x0e97, B:434:0x0ea5, B:493:0x10f0, B:436:0x0eae, B:438:0x0ee3, B:439:0x0eeb, B:441:0x0ef1, B:443:0x0f03, B:449:0x0f19, B:451:0x0f2f, B:452:0x0f52, B:454:0x0f5e, B:456:0x0f74, B:457:0x0fb4, B:463:0x0fce, B:465:0x0fd9, B:467:0x0fdd, B:469:0x0fe1, B:471:0x0fe5, B:472:0x0ff1, B:473:0x0ff6, B:475:0x0ffc, B:477:0x1014, B:478:0x101d, B:492:0x10ed, B:479:0x105d, B:481:0x1065, B:485:0x1079, B:487:0x1095, B:488:0x10a0, B:491:0x10e1, B:482:0x106a, B:494:0x10fa, B:496:0x1104, B:497:0x1118, B:498:0x1120, B:500:0x1126, B:501:0x113a, B:503:0x114c, B:529:0x121b, B:531:0x1221, B:533:0x1233, B:536:0x123a, B:541:0x127d, B:537:0x1249, B:539:0x1257, B:540:0x1264, B:542:0x128c, B:543:0x12a5, B:546:0x12ad, B:547:0x12b0, B:548:0x12c0, B:550:0x12da, B:551:0x12f3, B:552:0x12fb, B:556:0x1317, B:555:0x1306, B:504:0x1167, B:506:0x116d, B:508:0x117d, B:510:0x1184, B:516:0x119a, B:518:0x11a1, B:520:0x11b0, B:522:0x11bd, B:524:0x11e0, B:526:0x120c, B:528:0x1213, B:527:0x1210, B:523:0x11dd, B:517:0x119e, B:509:0x1181, B:402:0x0d9e, B:314:0x0990, B:308:0x0939, B:310:0x093f, B:559:0x1328, B:54:0x011b, B:71:0x019f, B:79:0x01e2, B:85:0x01fe, B:89:0x0214, B:93:0x022b, B:563:0x133b, B:564:0x133e, B:48:0x00dc, B:59:0x0127), top: B:567:0x0015, inners: #4, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(java.lang.String r50, long r51) {
        /*
            Method dump skipped, instruction units count: 4935
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.C(java.lang.String, long):boolean");
    }

    public final void D(ArrayList arrayList) {
        t7.v.a(!arrayList.isEmpty());
        if (this.S != null) {
            g().A.d("Set uploading progress before finishing the previous upload");
        } else {
            this.S = new ArrayList(arrayList);
        }
    }

    public final void E() {
        x().p1();
        if (this.N || this.O || this.P) {
            g().I.e("Not stopping services. fetch, network, upload", Boolean.valueOf(this.N), Boolean.valueOf(this.O), Boolean.valueOf(this.P));
            return;
        }
        g().I.d("Stopping uploading service(s)");
        ArrayList arrayList = this.J;
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
        ArrayList arrayList2 = this.J;
        t7.v.h(arrayList2);
        arrayList2.clear();
    }

    public final void F() {
        x().p1();
        HashSet<String> hashSet = this.K;
        for (String str : hashSet) {
            e9.a();
            if (S().A1(str, w.H0)) {
                g().H.c(str, "Notifying app that trigger URIs are available. App ID");
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intent.setPackage(str);
                this.F.f7282u.sendBroadcast(intent);
            }
        }
        hashSet.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G() {
        /*
            Method dump skipped, instruction units count: 1033
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.G():void");
    }

    public final boolean H() {
        x().p1();
        e0();
        i iVar = this.f7546w;
        y(iVar);
        if (iVar.e2("select count(1) > 0 from raw_events", null) != 0) {
            return true;
        }
        i iVar2 = this.f7546w;
        y(iVar2);
        return !TextUtils.isEmpty(iVar2.x1());
    }

    public final z1 I(String str) {
        x().p1();
        e0();
        HashMap map = this.V;
        z1 z1VarR2 = (z1) map.get(str);
        if (z1VarR2 == null) {
            i iVar = this.f7546w;
            y(iVar);
            z1VarR2 = iVar.r2(str);
            if (z1VarR2 == null) {
                z1VarR2 = z1.f7569c;
            }
            x().p1();
            e0();
            map.put(str, z1VarR2);
            i iVar2 = this.f7546w;
            y(iVar2);
            iVar2.i2(str, z1VarR2);
        }
        return z1VarR2;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01ad A[Catch: all -> 0x005d, TryCatch #1 {all -> 0x005d, blocks: (B:8:0x0030, B:17:0x004c, B:75:0x01b0, B:25:0x006a, B:30:0x00c6, B:29:0x00b4, B:31:0x00cb, B:34:0x00de, B:54:0x0120, B:58:0x0136, B:60:0x014e, B:62:0x016e, B:64:0x0177, B:66:0x017d, B:67:0x0181, B:69:0x018d, B:71:0x0196, B:73:0x01a5, B:74:0x01ad, B:61:0x015a, B:55:0x0127, B:57:0x0130, B:36:0x00e9, B:39:0x00f3, B:41:0x00f9, B:44:0x0103, B:47:0x010d, B:49:0x0113), top: B:84:0x0030, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(java.lang.String r10, int r11, java.lang.Throwable r12, byte[] r13, java.util.Map r14) {
        /*
            Method dump skipped, instruction units count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.J(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void K(d dVar, a4 a4Var) {
        v vVar;
        boolean z2;
        t7.v.d(dVar.f7128u);
        t7.v.h(dVar.f7129v);
        t7.v.h(dVar.f7130w);
        t7.v.d(dVar.f7130w.f7164v);
        x().p1();
        e0();
        if (a0(a4Var)) {
            if (!a4Var.B) {
                j(a4Var);
                return;
            }
            d dVar2 = new d(dVar);
            boolean z10 = false;
            dVar2.f7132y = false;
            i iVar = this.f7546w;
            y(iVar);
            iVar.v2();
            try {
                i iVar2 = this.f7546w;
                y(iVar2);
                String str = dVar2.f7128u;
                t7.v.h(str);
                d dVarL2 = iVar2.l2(str, dVar2.f7130w.f7164v);
                k1 k1Var = this.F;
                if (dVarL2 != null && !dVarL2.f7129v.equals(dVar2.f7129v)) {
                    g().D.e("Updating a conditional user property with different origin. name, origin, origin (from DB)", k1Var.G.g(dVar2.f7130w.f7164v), dVar2.f7129v, dVarL2.f7129v);
                }
                if (dVarL2 != null && (z2 = dVarL2.f7132y)) {
                    dVar2.f7129v = dVarL2.f7129v;
                    dVar2.f7131x = dVarL2.f7131x;
                    dVar2.B = dVarL2.B;
                    dVar2.f7133z = dVarL2.f7133z;
                    dVar2.C = dVarL2.C;
                    dVar2.f7132y = z2;
                    e4 e4Var = dVar2.f7130w;
                    dVar2.f7130w = new e4(dVarL2.f7130w.f7165w, e4Var.a(), e4Var.f7164v, dVarL2.f7130w.f7168z);
                } else if (TextUtils.isEmpty(dVar2.f7133z)) {
                    e4 e4Var2 = dVar2.f7130w;
                    dVar2.f7130w = new e4(dVar2.f7131x, e4Var2.a(), e4Var2.f7164v, dVar2.f7130w.f7168z);
                    z10 = true;
                    dVar2.f7132y = true;
                }
                if (dVar2.f7132y) {
                    e4 e4Var3 = dVar2.f7130w;
                    String str2 = dVar2.f7128u;
                    t7.v.h(str2);
                    String str3 = dVar2.f7129v;
                    String str4 = e4Var3.f7164v;
                    long j5 = e4Var3.f7165w;
                    Object objA = e4Var3.a();
                    t7.v.h(objA);
                    f4 f4Var = new f4(str2, str3, str4, j5, objA);
                    Object obj = f4Var.f7183e;
                    String str5 = f4Var.f7181c;
                    i iVar3 = this.f7546w;
                    y(iVar3);
                    if (iVar3.a2(f4Var)) {
                        g().H.e("User property updated immediately", dVar2.f7128u, k1Var.G.g(str5), obj);
                    } else {
                        g().A.e("(2)Too many active user properties, ignoring", p0.v1(dVar2.f7128u), k1Var.G.g(str5), obj);
                    }
                    if (z10 && (vVar = dVar2.C) != null) {
                        P(new v(vVar, dVar2.f7131x), a4Var);
                    }
                }
                i iVar4 = this.f7546w;
                y(iVar4);
                if (iVar4.Z1(dVar2)) {
                    g().H.e("Conditional property added", dVar2.f7128u, k1Var.G.g(dVar2.f7130w.f7164v), dVar2.f7130w.a());
                } else {
                    g().A.e("Too many conditional properties, ignoring", p0.v1(dVar2.f7128u), k1Var.G.g(dVar2.f7130w.f7164v), dVar2.f7130w.a());
                }
                i iVar5 = this.f7546w;
                y(iVar5);
                iVar5.C2();
                i iVar6 = this.f7546w;
                y(iVar6);
                iVar6.A2();
            } catch (Throwable th) {
                i iVar7 = this.f7546w;
                y(iVar7);
                iVar7.A2();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L(k8.v r11, k8.a4 r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.L(k8.v, k8.a4):void");
    }

    public final void M(g0 g0Var) {
        x().p1();
        if (TextUtils.isEmpty(g0Var.j()) && TextUtils.isEmpty(g0Var.d())) {
            String strF = g0Var.f();
            t7.v.h(strF);
            J(strF, 204, null, null, null);
            return;
        }
        s8.a();
        s.e eVar = null;
        boolean zA1 = S().A1(null, w.F0);
        s0 s0Var = this.f7545v;
        d1 d1Var = this.f7544u;
        if (!zA1) {
            this.D.getClass();
            String strT1 = v3.t1(g0Var);
            try {
                String strF2 = g0Var.f();
                t7.v.h(strF2);
                URL url = new URL(strT1);
                g().I.c(strF2, "Fetching remote configuration");
                y(d1Var);
                com.google.android.gms.internal.measurement.n2 n2VarG1 = d1Var.G1(strF2);
                y(d1Var);
                d1Var.p1();
                String str = (String) d1Var.H.get(strF2);
                if (n2VarG1 != null) {
                    if (!TextUtils.isEmpty(str)) {
                        eVar = new s.e(0);
                        eVar.put("If-Modified-Since", str);
                    }
                    y(d1Var);
                    d1Var.p1();
                    String str2 = (String) d1Var.I.get(strF2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (eVar == null) {
                            eVar = new s.e(0);
                        }
                        eVar.put("If-None-Match", str2);
                    }
                }
                this.N = true;
                y(s0Var);
                wb.c cVar = new wb.c(23, this);
                s0Var.p1();
                s0Var.t1();
                s0Var.x().w1(new v0(s0Var, strF2, url, null, eVar, cVar));
                return;
            } catch (MalformedURLException unused) {
                g().A.b(p0.v1(g0Var.f()), strT1, "Failed to parse config URL. Not fetching. appId");
                return;
            }
        }
        String strF3 = g0Var.f();
        t7.v.h(strF3);
        g().I.c(strF3, "Fetching remote configuration");
        y(d1Var);
        com.google.android.gms.internal.measurement.n2 n2VarG12 = d1Var.G1(strF3);
        y(d1Var);
        d1Var.p1();
        String str3 = (String) d1Var.H.get(strF3);
        if (n2VarG12 != null) {
            if (!TextUtils.isEmpty(str3)) {
                eVar = new s.e(0);
                eVar.put("If-Modified-Since", str3);
            }
            y(d1Var);
            d1Var.p1();
            String str4 = (String) d1Var.I.get(strF3);
            if (!TextUtils.isEmpty(str4)) {
                if (eVar == null) {
                    eVar = new s.e(0);
                }
                eVar.put("If-None-Match", str4);
            }
        }
        s.e eVar2 = eVar;
        this.N = true;
        y(s0Var);
        u5.d dVar = new u5.d(20, false);
        dVar.f12784v = this;
        s0Var.p1();
        s0Var.t1();
        s0Var.f7443w.D.getClass();
        String strT12 = v3.t1(g0Var);
        try {
            s0Var.x().w1(new v0(s0Var, g0Var.f(), new URI(strT12).toURL(), null, eVar2, dVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            s0Var.g().A.b(p0.v1(g0Var.f()), strT12, "Failed to parse config URL. Not fetching. appId");
        }
    }

    public final void N(g0 g0Var, com.google.android.gms.internal.measurement.m3 m3Var) {
        x().p1();
        e0();
        com.google.android.gms.internal.measurement.v2 v2VarX = com.google.android.gms.internal.measurement.w2.x();
        k1 k1Var = g0Var.f7185a;
        h1 h1Var = k1Var.D;
        k1.f(h1Var);
        h1Var.p1();
        byte[] bArr = g0Var.I;
        if (bArr != null) {
            try {
                v2VarX = (com.google.android.gms.internal.measurement.v2) s0.D1(v2VarX, bArr);
            } catch (r5 unused) {
                g().D.c(p0.v1(g0Var.f()), "Failed to parse locally stored ad campaign info. appId");
            }
        }
        for (com.google.android.gms.internal.measurement.f3 f3Var : m3Var.n()) {
            if (f3Var.B().equals("_cmp")) {
                Serializable serializableA2 = s0.a2(f3Var, "gclid");
                if (serializableA2 == null) {
                    serializableA2 = "";
                }
                String str = (String) serializableA2;
                Serializable serializableA22 = s0.a2(f3Var, "gbraid");
                if (serializableA22 == null) {
                    serializableA22 = "";
                }
                String str2 = (String) serializableA22;
                Serializable serializableA23 = s0.a2(f3Var, "gad_source");
                String str3 = (String) (serializableA23 != null ? serializableA23 : "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    Serializable serializableA24 = s0.a2(f3Var, "click_timestamp");
                    long jLongValue = ((Long) (serializableA24 != null ? serializableA24 : 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = f3Var.z();
                    }
                    if ("referrer API v2".equals(s0.a2(f3Var, "_cis"))) {
                        if (jLongValue > ((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v).r()) {
                            if (str.isEmpty()) {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.E((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                            } else {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.F((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str);
                            }
                            if (str2.isEmpty()) {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.B((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                            } else {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.C((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str2);
                            }
                            if (str3.isEmpty()) {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.y((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                            } else {
                                v2VarX.e();
                                com.google.android.gms.internal.measurement.w2.z((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str3);
                            }
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.t((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, jLongValue);
                        }
                    } else if (jLongValue > ((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v).n()) {
                        if (str.isEmpty()) {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.v((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                        } else {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.w((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str);
                        }
                        if (str2.isEmpty()) {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.s((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                        } else {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.u((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str2);
                        }
                        if (str3.isEmpty()) {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.o((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v);
                        } else {
                            v2VarX.e();
                            com.google.android.gms.internal.measurement.w2.q((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, str3);
                        }
                        v2VarX.e();
                        com.google.android.gms.internal.measurement.w2.p((com.google.android.gms.internal.measurement.w2) v2VarX.f3052v, jLongValue);
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.w2) v2VarX.c()).equals(com.google.android.gms.internal.measurement.w2.A())) {
            com.google.android.gms.internal.measurement.w2 w2Var = (com.google.android.gms.internal.measurement.w2) v2VarX.c();
            m3Var.e();
            com.google.android.gms.internal.measurement.n3.u((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, w2Var);
        }
        byte[] bArrC = ((com.google.android.gms.internal.measurement.w2) v2VarX.c()).c();
        h1 h1Var2 = k1Var.D;
        k1.f(h1Var2);
        h1Var2.p1();
        g0Var.Q |= g0Var.I != bArrC;
        g0Var.I = bArrC;
        if (g0Var.n()) {
            i iVar = this.f7546w;
            y(iVar);
            iVar.V1(g0Var, false);
        }
    }

    public final a4 O(String str) {
        i iVar = this.f7546w;
        y(iVar);
        g0 g0VarN2 = iVar.n2(str);
        if (g0VarN2 != null) {
            k1 k1Var = g0VarN2.f7185a;
            if (!TextUtils.isEmpty(g0VarN2.h())) {
                Boolean boolE = e(g0VarN2);
                if (boolE != null && !boolE.booleanValue()) {
                    g().A.c(p0.v1(str), "App version does not match; dropping. appId");
                    return null;
                }
                String strJ = g0VarN2.j();
                String strH = g0VarN2.h();
                long jY = g0VarN2.y();
                h1 h1Var = k1Var.D;
                k1.f(h1Var);
                h1Var.p1();
                String str2 = g0VarN2.f7194l;
                h1 h1Var2 = k1Var.D;
                k1.f(h1Var2);
                h1Var2.p1();
                long j5 = g0VarN2.f7195m;
                h1 h1Var3 = k1Var.D;
                k1.f(h1Var3);
                h1Var3.p1();
                long j8 = g0VarN2.f7196n;
                h1 h1Var4 = k1Var.D;
                k1.f(h1Var4);
                h1Var4.p1();
                boolean z2 = g0VarN2.f7197o;
                String strI = g0VarN2.i();
                h1 h1Var5 = k1Var.D;
                k1.f(h1Var5);
                h1Var5.p1();
                h1 h1Var6 = k1Var.D;
                k1.f(h1Var6);
                h1Var6.p1();
                boolean z10 = g0VarN2.f7198p;
                String strD = g0VarN2.d();
                Boolean boolU = g0VarN2.U();
                long jN = g0VarN2.N();
                h1 h1Var7 = k1Var.D;
                k1.f(h1Var7);
                h1Var7.p1();
                ArrayList arrayList = g0VarN2.f7202t;
                String strM = I(str).m();
                boolean zO = g0VarN2.o();
                h1 h1Var8 = k1Var.D;
                k1.f(h1Var8);
                h1Var8.p1();
                long j10 = g0VarN2.f7205w;
                int i = I(str).f7571b;
                String str3 = Q(str).f7338b;
                h1 h1Var9 = k1Var.D;
                k1.f(h1Var9);
                h1Var9.p1();
                int i10 = g0VarN2.f7207y;
                h1 h1Var10 = k1Var.D;
                k1.f(h1Var10);
                h1Var10.p1();
                return new a4(str, strJ, strH, jY, str2, j5, j8, null, z2, false, strI, 0L, 0, z10, false, strD, boolU, jN, arrayList, strM, "", null, zO, j10, i, str3, i10, g0VarN2.C, g0VarN2.l(), g0VarN2.k());
            }
        }
        g().H.c(str, "No app data available; dropping");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x039b A[Catch: all -> 0x0213, TryCatch #1 {all -> 0x0213, blocks: (B:46:0x01f5, B:49:0x0202, B:51:0x020a, B:58:0x0219, B:118:0x03cf, B:120:0x041d, B:122:0x0423, B:123:0x043a, B:127:0x044b, B:129:0x0465, B:131:0x046b, B:132:0x0482, B:138:0x04ab, B:142:0x04cf, B:143:0x04e6, B:147:0x04f7, B:150:0x0512, B:151:0x0522, B:153:0x052a, B:155:0x0536, B:157:0x053c, B:158:0x0545, B:160:0x0551, B:162:0x0559, B:164:0x0561, B:166:0x0567, B:168:0x056b, B:169:0x0577, B:171:0x0583, B:172:0x0598, B:174:0x05c5, B:177:0x05ee, B:181:0x063c, B:183:0x0657, B:185:0x068a, B:186:0x068d, B:188:0x0693, B:190:0x069b, B:192:0x06a1, B:194:0x06a9, B:196:0x06af, B:200:0x06be, B:203:0x06ca, B:205:0x06d3, B:207:0x06db, B:209:0x0709, B:211:0x070f, B:212:0x0714, B:214:0x0723, B:216:0x0737, B:222:0x074e, B:226:0x0763, B:231:0x0773, B:233:0x077a, B:237:0x0788, B:241:0x0797, B:245:0x07a6, B:249:0x07b5, B:253:0x07c4, B:257:0x07d3, B:261:0x07e2, B:263:0x07f1, B:265:0x07f7, B:266:0x07fa, B:268:0x0809, B:269:0x080c, B:281:0x0854, B:182:0x0646, B:65:0x0236, B:68:0x0240, B:70:0x0255, B:76:0x026d, B:84:0x02a3, B:86:0x02a9, B:88:0x02b7, B:90:0x02cf, B:93:0x02d8, B:114:0x0391, B:116:0x039b, B:95:0x0306, B:96:0x031f, B:98:0x0325, B:104:0x033a, B:106:0x033e, B:113:0x0375, B:112:0x0363, B:79:0x0279, B:83:0x029f), top: B:378:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x041d A[Catch: all -> 0x0213, TryCatch #1 {all -> 0x0213, blocks: (B:46:0x01f5, B:49:0x0202, B:51:0x020a, B:58:0x0219, B:118:0x03cf, B:120:0x041d, B:122:0x0423, B:123:0x043a, B:127:0x044b, B:129:0x0465, B:131:0x046b, B:132:0x0482, B:138:0x04ab, B:142:0x04cf, B:143:0x04e6, B:147:0x04f7, B:150:0x0512, B:151:0x0522, B:153:0x052a, B:155:0x0536, B:157:0x053c, B:158:0x0545, B:160:0x0551, B:162:0x0559, B:164:0x0561, B:166:0x0567, B:168:0x056b, B:169:0x0577, B:171:0x0583, B:172:0x0598, B:174:0x05c5, B:177:0x05ee, B:181:0x063c, B:183:0x0657, B:185:0x068a, B:186:0x068d, B:188:0x0693, B:190:0x069b, B:192:0x06a1, B:194:0x06a9, B:196:0x06af, B:200:0x06be, B:203:0x06ca, B:205:0x06d3, B:207:0x06db, B:209:0x0709, B:211:0x070f, B:212:0x0714, B:214:0x0723, B:216:0x0737, B:222:0x074e, B:226:0x0763, B:231:0x0773, B:233:0x077a, B:237:0x0788, B:241:0x0797, B:245:0x07a6, B:249:0x07b5, B:253:0x07c4, B:257:0x07d3, B:261:0x07e2, B:263:0x07f1, B:265:0x07f7, B:266:0x07fa, B:268:0x0809, B:269:0x080c, B:281:0x0854, B:182:0x0646, B:65:0x0236, B:68:0x0240, B:70:0x0255, B:76:0x026d, B:84:0x02a3, B:86:0x02a9, B:88:0x02b7, B:90:0x02cf, B:93:0x02d8, B:114:0x0391, B:116:0x039b, B:95:0x0306, B:96:0x031f, B:98:0x0325, B:104:0x033a, B:106:0x033e, B:113:0x0375, B:112:0x0363, B:79:0x0279, B:83:0x029f), top: B:378:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x07ef  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0917  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x095e A[Catch: all -> 0x08c5, TryCatch #4 {all -> 0x08c5, blocks: (B:272:0x0824, B:274:0x082f, B:276:0x083d, B:279:0x0849, B:282:0x085d, B:284:0x0869, B:286:0x0875, B:288:0x087f, B:290:0x088d, B:292:0x08a3, B:294:0x08b1, B:298:0x08ce, B:300:0x08dc, B:305:0x090e, B:307:0x091b, B:309:0x095e, B:312:0x0969, B:313:0x0973, B:314:0x0974, B:316:0x097e, B:302:0x08e8, B:304:0x08f8, B:275:0x0834), top: B:383:0x0824 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x097e A[Catch: all -> 0x08c5, TRY_LEAVE, TryCatch #4 {all -> 0x08c5, blocks: (B:272:0x0824, B:274:0x082f, B:276:0x083d, B:279:0x0849, B:282:0x085d, B:284:0x0869, B:286:0x0875, B:288:0x087f, B:290:0x088d, B:292:0x08a3, B:294:0x08b1, B:298:0x08ce, B:300:0x08dc, B:305:0x090e, B:307:0x091b, B:309:0x095e, B:312:0x0969, B:313:0x0973, B:314:0x0974, B:316:0x097e, B:302:0x08e8, B:304:0x08f8, B:275:0x0834), top: B:383:0x0824 }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x09e2  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0a0b A[Catch: all -> 0x09aa, TryCatch #6 {all -> 0x09aa, blocks: (B:318:0x0987, B:320:0x099c, B:324:0x09ad, B:326:0x09e7, B:328:0x09ed, B:330:0x09f7, B:331:0x0a01, B:333:0x0a0b, B:334:0x0a15, B:335:0x0a1e, B:337:0x0a24, B:339:0x0a6e, B:341:0x0a80, B:345:0x0a9f, B:347:0x0aaf, B:344:0x0a8f, B:351:0x0ac2, B:352:0x0ad0, B:354:0x0ada, B:355:0x0ade, B:357:0x0ae7, B:360:0x0af6, B:362:0x0b21, B:365:0x0b3a, B:367:0x0b40, B:370:0x0b5b, B:369:0x0b46), top: B:386:0x0987, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0a24 A[Catch: all -> 0x09aa, TryCatch #6 {all -> 0x09aa, blocks: (B:318:0x0987, B:320:0x099c, B:324:0x09ad, B:326:0x09e7, B:328:0x09ed, B:330:0x09f7, B:331:0x0a01, B:333:0x0a0b, B:334:0x0a15, B:335:0x0a1e, B:337:0x0a24, B:339:0x0a6e, B:341:0x0a80, B:345:0x0a9f, B:347:0x0aaf, B:344:0x0a8f, B:351:0x0ac2, B:352:0x0ad0, B:354:0x0ada, B:355:0x0ade, B:357:0x0ae7, B:360:0x0af6, B:362:0x0b21, B:365:0x0b3a, B:367:0x0b40, B:370:0x0b5b, B:369:0x0b46), top: B:386:0x0987, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0aba  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0ada A[Catch: all -> 0x09aa, TryCatch #6 {all -> 0x09aa, blocks: (B:318:0x0987, B:320:0x099c, B:324:0x09ad, B:326:0x09e7, B:328:0x09ed, B:330:0x09f7, B:331:0x0a01, B:333:0x0a0b, B:334:0x0a15, B:335:0x0a1e, B:337:0x0a24, B:339:0x0a6e, B:341:0x0a80, B:345:0x0a9f, B:347:0x0aaf, B:344:0x0a8f, B:351:0x0ac2, B:352:0x0ad0, B:354:0x0ada, B:355:0x0ade, B:357:0x0ae7, B:360:0x0af6, B:362:0x0b21, B:365:0x0b3a, B:367:0x0b40, B:370:0x0b5b, B:369:0x0b46), top: B:386:0x0987, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0b40 A[Catch: all -> 0x09aa, TryCatch #6 {all -> 0x09aa, blocks: (B:318:0x0987, B:320:0x099c, B:324:0x09ad, B:326:0x09e7, B:328:0x09ed, B:330:0x09f7, B:331:0x0a01, B:333:0x0a0b, B:334:0x0a15, B:335:0x0a1e, B:337:0x0a24, B:339:0x0a6e, B:341:0x0a80, B:345:0x0a9f, B:347:0x0aaf, B:344:0x0a8f, B:351:0x0ac2, B:352:0x0ad0, B:354:0x0ada, B:355:0x0ade, B:357:0x0ae7, B:360:0x0af6, B:362:0x0b21, B:365:0x0b3a, B:367:0x0b40, B:370:0x0b5b, B:369:0x0b46), top: B:386:0x0987, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d5  */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29, types: [int] */
    /* JADX WARN: Type inference failed for: r6v68 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(k8.v r50, k8.a4 r51) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.P(k8.v, k8.a4):void");
    }

    public final o Q(String str) {
        x().p1();
        e0();
        HashMap map = this.W;
        o oVar = (o) map.get(str);
        if (oVar != null) {
            return oVar;
        }
        i iVar = this.f7546w;
        y(iVar);
        t7.v.h(str);
        iVar.p1();
        iVar.t1();
        o oVarC = o.c(iVar.D1("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}));
        map.put(str, oVarC);
        return oVarC;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03bf A[Catch: all -> 0x00d7, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03da A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0497 A[Catch: all -> 0x00d7, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0502 A[Catch: all -> 0x00d7, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011f A[Catch: all -> 0x00d7, TRY_ENTER, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ed A[Catch: all -> 0x00d7, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024b A[Catch: all -> 0x00d7, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0269 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #3 {all -> 0x00d7, blocks: (B:26:0x00b8, B:28:0x00ca, B:35:0x00de, B:39:0x00ef, B:41:0x00fc, B:43:0x0106, B:45:0x010c, B:46:0x010f, B:49:0x011f, B:51:0x0134, B:52:0x0159, B:54:0x0167, B:56:0x01c1, B:67:0x01ed, B:69:0x01f8, B:73:0x0207, B:76:0x0215, B:80:0x0220, B:82:0x0223, B:83:0x0246, B:85:0x024b, B:91:0x0269, B:94:0x027d, B:96:0x02a3, B:128:0x0393, B:130:0x03bf, B:131:0x03c2, B:133:0x03da, B:174:0x0497, B:175:0x049a, B:185:0x0523, B:136:0x03ef, B:141:0x040c, B:143:0x0414, B:145:0x041a, B:149:0x042d, B:153:0x043c, B:157:0x0447, B:160:0x045b, B:165:0x0478, B:167:0x0480, B:169:0x0488, B:171:0x048e, B:163:0x0466, B:150:0x0433, B:139:0x03fa, B:98:0x02b5, B:100:0x02c5, B:101:0x02d4, B:103:0x0300, B:104:0x0310, B:106:0x0317, B:108:0x031d, B:110:0x0327, B:112:0x032d, B:114:0x0333, B:116:0x0339, B:117:0x033e, B:123:0x035f, B:125:0x0363, B:126:0x0376, B:127:0x0385, B:178:0x04b9, B:180:0x04e7, B:181:0x04ea, B:182:0x0502, B:184:0x0507, B:88:0x025a, B:62:0x01d6), top: B:196:0x00b8, inners: #0, #1, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(k8.a4 r32) {
        /*
            Method dump skipped, instruction units count: 1341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.R(k8.a4):void");
    }

    public final e S() {
        k1 k1Var = this.F;
        t7.v.h(k1Var);
        return k1Var.A;
    }

    public final void T(String str) {
        String str2;
        s0 s0Var;
        URL url;
        HashMap map;
        c4 c4Var;
        x().p1();
        e0();
        this.P = true;
        try {
            Boolean bool = this.F.p().f7574z;
            if (bool == null) {
                g().D.d("Upload data called on the client side before use of service was decided");
                this.P = false;
                E();
                return;
            }
            if (bool.booleanValue()) {
                g().A.d("Upload called in the client side when service should be used");
                this.P = false;
                E();
                return;
            }
            if (this.I > 0) {
                G();
                this.P = false;
                E();
                return;
            }
            s0 s0Var2 = this.f7545v;
            y(s0Var2);
            if (!s0Var2.g2()) {
                g().I.d("Network not connected, ignoring upload request");
                G();
                this.P = false;
                E();
                return;
            }
            i iVar = this.f7546w;
            y(iVar);
            if (!iVar.z2(str)) {
                g().I.c(str, "Upload queue has no batches for appId");
                this.P = false;
                E();
                return;
            }
            i iVar2 = this.f7546w;
            y(iVar2);
            d4 d4VarT2 = iVar2.t2(str);
            if (d4VarT2 == null) {
                this.P = false;
                E();
                return;
            }
            com.google.android.gms.internal.measurement.l3 l3Var = d4VarT2.f7140b;
            if (l3Var == null) {
                this.P = false;
                E();
                return;
            }
            s0 s0Var3 = this.A;
            y(s0Var3);
            String strE1 = s0Var3.E1(l3Var);
            byte[] bArrC = l3Var.c();
            g().I.e("Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrC.length), strE1);
            s8.a();
            if (S().A1(null, w.F0)) {
                this.O = true;
                s0 s0Var4 = this.f7545v;
                y(s0Var4);
                s0Var4.R1(str, new y3(d4VarT2.f7141c, d4VarT2.f7142d, d4VarT2.f7143e), l3Var, new c4(this, str, d4VarT2, 0));
            } else {
                try {
                    this.O = true;
                    s0Var = this.f7545v;
                    y(s0Var);
                    url = new URL(d4VarT2.f7141c);
                    map = d4VarT2.f7142d;
                    c4Var = new c4(this, str, d4VarT2, 1);
                    s0Var.p1();
                    s0Var.t1();
                    str2 = str;
                } catch (MalformedURLException unused) {
                    str2 = str;
                }
                try {
                    s0Var.x().w1(new v0(s0Var, str2, url, bArrC, map, c4Var));
                } catch (MalformedURLException unused2) {
                    g().A.b(p0.v1(str2), d4VarT2.f7141c, "Failed to parse URL. Not uploading MeasurementBatch. appId");
                }
            }
            this.P = false;
            E();
        } catch (Throwable th) {
            this.P = false;
            E();
            throw th;
        }
    }

    public final void U(a4 a4Var) {
        if (this.S != null) {
            ArrayList arrayList = new ArrayList();
            this.T = arrayList;
            arrayList.addAll(this.S);
        }
        i iVar = this.f7546w;
        y(iVar);
        String str = a4Var.f7076u;
        t7.v.h(str);
        t7.v.d(str);
        iVar.p1();
        iVar.t1();
        try {
            SQLiteDatabase sQLiteDatabaseW1 = iVar.w1();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseW1.delete("apps", "app_id=?", strArr) + sQLiteDatabaseW1.delete("events", "app_id=?", strArr) + sQLiteDatabaseW1.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseW1.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseW1.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseW1.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseW1.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseW1.delete("queue", "app_id=?", strArr) + sQLiteDatabaseW1.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseW1.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseW1.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseW1.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseW1.delete("upload_queue", "app_id=?", strArr);
            if (iDelete > 0) {
                iVar.g().I.b(str, Integer.valueOf(iDelete), "Reset analytics data. app, records");
            }
        } catch (SQLiteException e10) {
            iVar.g().A.b(p0.v1(str), e10, "Error resetting analytics data. appId, error");
        }
        if (a4Var.B) {
            R(a4Var);
        }
    }

    public final i V() {
        i iVar = this.f7546w;
        y(iVar);
        return iVar;
    }

    public final void W(a4 a4Var) {
        x().p1();
        e0();
        t7.v.d(a4Var.f7076u);
        o oVarC = o.c(a4Var.V);
        r0 r0Var = g().I;
        String str = a4Var.f7076u;
        r0Var.b(str, oVarC, "Setting DMA consent for package");
        x().p1();
        e0();
        b2 b2VarD = o.b(100, d(str)).d();
        this.W.put(str, oVarC);
        i iVar = this.f7546w;
        y(iVar);
        t7.v.h(str);
        t7.v.h(oVarC);
        iVar.p1();
        iVar.t1();
        if (((k1) iVar.f2454v).A.A1(null, w.R0)) {
            z1 z1VarR2 = iVar.r2(str);
            z1 z1Var = z1.f7569c;
            if (z1VarR2 == z1Var) {
                iVar.i2(str, z1Var);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", oVarC.f7338b);
        iVar.J1(contentValues);
        b2 b2VarD2 = o.b(100, d(str)).d();
        x().p1();
        e0();
        b2 b2Var = b2.f7092y;
        b2 b2Var2 = b2.f7091x;
        boolean z2 = b2VarD == b2Var2 && b2VarD2 == b2Var;
        boolean z10 = b2VarD == b2Var && b2VarD2 == b2Var2;
        if (S().A1(null, w.Q0)) {
            z2 = z2 || z10;
        }
        if (z2) {
            g().I.c(str, "Generated _dcu event for");
            Bundle bundle = new Bundle();
            i iVar2 = this.f7546w;
            y(iVar2);
            if (iVar2.I1(g0(), str, false, false, false, false).f < S().u1(str, w.Z)) {
                bundle.putLong("_r", 1L);
                i iVar3 = this.f7546w;
                y(iVar3);
                g().I.b(str, Long.valueOf(iVar3.I1(g0(), str, false, false, true, false).f), "_dcu realtime event count");
            }
            this.f7543a0.b(str, "_dcu", bundle);
        }
    }

    public final void X(a4 a4Var) {
        x().p1();
        e0();
        t7.v.d(a4Var.f7076u);
        z1 z1VarD = z1.d(a4Var.P, a4Var.U);
        String str = a4Var.f7076u;
        z1 z1VarI = I(str);
        g().I.b(str, z1VarD, "Setting storage consent for package");
        x().p1();
        e0();
        this.V.put(str, z1VarD);
        i iVar = this.f7546w;
        y(iVar);
        iVar.i2(str, z1VarD);
        d7.a();
        if (S().A1(null, w.Y0) || !z1VarD.k(z1VarI, (y1[]) z1VarD.f7570a.keySet().toArray(new y1[0]))) {
            return;
        }
        U(a4Var);
    }

    public final d1 Z() {
        d1 d1Var = this.f7544u;
        y(d1Var);
        return d1Var;
    }

    @Override // k8.w1
    public final Context a() {
        return this.F.f7282u;
    }

    @Override // k8.w1
    public final q9.e b() {
        return this.F.f7287z;
    }

    public final s0 b0() {
        s0 s0Var = this.A;
        y(s0Var);
        return s0Var;
    }

    public final int c(String str, rc.b bVar) {
        b2 b2VarZ1;
        d1 d1Var = this.f7544u;
        com.google.android.gms.internal.measurement.i2 i2VarF1 = d1Var.F1(str);
        y1 y1Var = y1.f7557y;
        if (i2VarF1 == null) {
            bVar.M(y1Var, h.FAILSAFE);
            return 1;
        }
        i iVar = this.f7546w;
        y(iVar);
        g0 g0VarN2 = iVar.n2(str);
        if (g0VarN2 == null || ((b2) u5.c.q(g0VarN2.k()).f12782v) != b2.f7090w || (b2VarZ1 = d1Var.z1(str, y1Var)) == b2.f7089v) {
            bVar.M(y1Var, h.REMOTE_DEFAULT);
            if (d1Var.I1(str, y1Var)) {
                return 0;
            }
        } else {
            bVar.M(y1Var, h.REMOTE_ENFORCED_DEFAULT);
            if (b2VarZ1 == b2.f7092y) {
                return 0;
            }
        }
        return 1;
    }

    public final h4 c0() {
        k1 k1Var = this.F;
        t7.v.h(k1Var);
        h4 h4Var = k1Var.F;
        k1.d(h4Var);
        return h4Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final Bundle d(String str) {
        x().p1();
        e0();
        d1 d1Var = this.f7544u;
        y(d1Var);
        if (d1Var.F1(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        z1 z1VarI = I(str);
        Bundle bundle2 = new Bundle();
        Iterator it = z1VarI.f7570a.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((b2) entry.getValue()).ordinal();
            String str2 = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str2 != null) {
                bundle2.putString(((y1) entry.getKey()).f7559u, str2);
            }
        }
        bundle.putAll(bundle2);
        o oVarI = i(str, Q(str), z1VarI, new rc.b(17));
        Bundle bundle3 = new Bundle();
        for (Map.Entry entry2 : oVarI.f7341e.entrySet()) {
            int iOrdinal2 = ((b2) entry2.getValue()).ordinal();
            String str3 = iOrdinal2 != 2 ? iOrdinal2 != 3 ? null : "granted" : "denied";
            if (str3 != null) {
                bundle3.putString(((y1) entry2.getKey()).f7559u, str3);
            }
        }
        Boolean bool = oVarI.f7339c;
        if (bool != null) {
            bundle3.putString("is_dma_region", bool.toString());
        }
        String str4 = oVarI.f7340d;
        if (str4 != null) {
            bundle3.putString("cps_display_str", str4);
        }
        bundle.putAll(bundle3);
        i iVar = this.f7546w;
        y(iVar);
        f4 f4VarO2 = iVar.o2(str, "_npa");
        bundle.putString("ad_personalization", (f4VarO2 != null ? f4VarO2.f7183e.equals(1L) : c(str, new rc.b(17))) != 1 ? "granted" : "denied");
        return bundle;
    }

    public final void d0() {
        x().p1();
        e0();
        if (this.H) {
            return;
        }
        this.H = true;
        x().p1();
        FileLock fileLock = this.Q;
        k1 k1Var = this.F;
        if (fileLock == null || !fileLock.isValid()) {
            File filesDir = k1Var.f7282u.getFilesDir();
            int i = com.google.android.gms.internal.measurement.n0.f3113c;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.R = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.Q = fileLockTryLock;
                if (fileLockTryLock == null) {
                    g().A.d("Storage concurrent data access panic");
                    return;
                }
                g().I.d("Storage concurrent access okay");
            } catch (FileNotFoundException e10) {
                g().A.c(e10, "Failed to acquire storage lock");
                return;
            } catch (IOException e11) {
                g().A.c(e11, "Failed to access storage lock file");
                return;
            } catch (OverlappingFileLockException e12) {
                g().D.c(e12, "Storage lock already acquired");
                return;
            }
        } else {
            g().I.d("Storage concurrent access okay");
        }
        FileChannel fileChannel = this.R;
        x().p1();
        int i10 = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            g().A.d("Bad channel to read from");
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int i11 = fileChannel.read(byteBufferAllocate);
                if (i11 == 4) {
                    byteBufferAllocate.flip();
                    i10 = byteBufferAllocate.getInt();
                } else if (i11 != -1) {
                    g().D.c(Integer.valueOf(i11), "Unexpected data length. Bytes read");
                }
            } catch (IOException e13) {
                g().A.c(e13, "Failed to read from channel");
            }
        }
        k0 k0VarM = k1Var.m();
        k0VarM.t1();
        int i12 = k0VarM.f7278z;
        x().p1();
        if (i10 > i12) {
            g().A.b(Integer.valueOf(i10), Integer.valueOf(i12), "Panic: can't downgrade version. Previous, current version");
            return;
        }
        if (i10 < i12) {
            FileChannel fileChannel2 = this.R;
            x().p1();
            if (fileChannel2 == null || !fileChannel2.isOpen()) {
                g().A.d("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                byteBufferAllocate2.putInt(i12);
                byteBufferAllocate2.flip();
                try {
                    fileChannel2.truncate(0L);
                    fileChannel2.write(byteBufferAllocate2);
                    fileChannel2.force(true);
                    if (fileChannel2.size() != 4) {
                        g().A.c(Long.valueOf(fileChannel2.size()), "Error writing to channel. Bytes written");
                    }
                    g().I.b(Integer.valueOf(i10), Integer.valueOf(i12), "Storage version upgraded. Previous, current version");
                    return;
                } catch (IOException e14) {
                    g().A.c(e14, "Failed to write to channel");
                }
            }
            g().A.b(Integer.valueOf(i10), Integer.valueOf(i12), "Storage version upgrade failed. Previous, current version");
        }
    }

    public final Boolean e(g0 g0Var) {
        try {
            long jY = g0Var.y();
            k1 k1Var = this.F;
            if (jY != -2147483648L) {
                if (g0Var.y() == z7.b.a(k1Var.f7282u).c(g0Var.f(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = z7.b.a(k1Var.f7282u).c(g0Var.f(), 0).versionName;
                String strH = g0Var.h();
                if (strH != null && strH.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void e0() {
        if (!this.G) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0144 A[Catch: all -> 0x002d, TryCatch #7 {all -> 0x002d, blocks: (B:5:0x001c, B:12:0x0037, B:18:0x0050, B:23:0x0064, B:28:0x0080, B:34:0x00be, B:40:0x00d9, B:46:0x0105, B:50:0x011a, B:66:0x013f, B:53:0x0122, B:68:0x0144, B:69:0x0147, B:65:0x013c, B:74:0x0179, B:75:0x017d, B:77:0x0183, B:79:0x0197, B:83:0x01a0, B:85:0x01a6, B:87:0x01ba, B:89:0x01c4, B:94:0x01f1), top: B:252:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0() {
        /*
            Method dump skipped, instruction units count: 1818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.f0():void");
    }

    @Override // k8.w1
    public final p0 g() {
        k1 k1Var = this.F;
        t7.v.h(k1Var);
        p0 p0Var = k1Var.C;
        k1.f(p0Var);
        return p0Var;
    }

    public final long g0() {
        y0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        j3 j3Var = this.C;
        j3Var.t1();
        j3Var.p1();
        a2.e2 e2Var = j3Var.E;
        long jC = e2Var.c();
        if (jC == 0) {
            jC = ((long) j3Var.o1().D2().nextInt(86400000)) + 1;
            e2Var.d(jC);
        }
        return ((((jCurrentTimeMillis + jC) / 1000) / 60) / 60) / 24;
    }

    public final String h(z1 z1Var) {
        if (!z1Var.i(y1.f7555w)) {
            return null;
        }
        byte[] bArr = new byte[16];
        c0().D2().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final w0 h0() {
        w0 w0Var = this.f7547x;
        if (w0Var != null) {
            return w0Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final o i(String str, o oVar, z1 z1Var, rc.b bVar) {
        b2 b2VarZ1;
        d1 d1Var = this.f7544u;
        y(d1Var);
        com.google.android.gms.internal.measurement.i2 i2VarF1 = d1Var.F1(str);
        int i = 90;
        b2 b2Var = b2.f7091x;
        y1 y1Var = y1.f7556x;
        if (i2VarF1 == null) {
            if (oVar.d() == b2Var) {
                i = oVar.f7337a;
                bVar.L(y1Var, i);
            } else {
                bVar.M(y1Var, h.FAILSAFE);
            }
            return new o(Boolean.FALSE, i, Boolean.TRUE, "-");
        }
        b2 b2VarD = oVar.d();
        boolean z2 = true;
        b2 b2Var2 = b2.f7092y;
        if (b2VarD == b2Var2 || b2VarD == b2Var) {
            i = oVar.f7337a;
            bVar.L(y1Var, i);
        } else {
            b2 b2Var3 = b2.f7090w;
            b2 b2Var4 = b2.f7089v;
            if (b2VarD != b2Var3 || (b2VarZ1 = d1Var.z1(str, y1Var)) == b2Var4) {
                d1Var.p1();
                d1Var.N1(str);
                com.google.android.gms.internal.measurement.i2 i2VarF12 = d1Var.F1(str);
                y1 y1VarY1 = null;
                if (i2VarF12 != null) {
                    Iterator it = i2VarF12.q().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.g2 g2Var = (com.google.android.gms.internal.measurement.g2) it.next();
                        if (y1Var == d1.y1(g2Var.o())) {
                            y1VarY1 = d1.y1(g2Var.n());
                            break;
                        }
                    }
                }
                EnumMap enumMap = z1Var.f7570a;
                y1 y1Var2 = y1.f7554v;
                b2 b2Var5 = (b2) enumMap.get(y1Var2);
                if (b2Var5 != null) {
                    b2Var4 = b2Var5;
                }
                boolean z10 = b2Var4 == b2Var2 || b2Var4 == b2Var;
                if (y1VarY1 == y1Var2 && z10) {
                    bVar.M(y1Var, h.REMOTE_DELEGATION);
                    b2VarD = b2Var4;
                } else {
                    bVar.M(y1Var, h.REMOTE_DEFAULT);
                    b2VarD = d1Var.I1(str, y1Var) ? b2Var2 : b2Var;
                }
            } else {
                bVar.M(y1Var, h.REMOTE_ENFORCED_DEFAULT);
                b2VarD = b2VarZ1;
            }
        }
        d1Var.p1();
        d1Var.N1(str);
        com.google.android.gms.internal.measurement.i2 i2VarF13 = d1Var.F1(str);
        if (i2VarF13 != null && i2VarF13.t() && !i2VarF13.s()) {
            z2 = false;
        }
        y(d1Var);
        d1Var.p1();
        d1Var.N1(str);
        TreeSet treeSet = new TreeSet();
        com.google.android.gms.internal.measurement.i2 i2VarF14 = d1Var.F1(str);
        if (i2VarF14 != null) {
            Iterator it2 = i2VarF14.o().iterator();
            while (it2.hasNext()) {
                treeSet.add(((com.google.android.gms.internal.measurement.h2) it2.next()).n());
            }
        }
        if (b2VarD == b2Var || treeSet.isEmpty()) {
            return new o(Boolean.FALSE, i, Boolean.valueOf(z2), "-");
        }
        return new o(Boolean.TRUE, i, Boolean.valueOf(z2), z2 ? TextUtils.join("", treeSet) : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.g0 j(k8.a4 r26) {
        /*
            Method dump skipped, instruction units count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.j(k8.a4):k8.g0");
    }

    public final void n(com.google.android.gms.internal.measurement.m3 m3Var, long j5, boolean z2) {
        f4 f4Var;
        Object obj;
        String str = z2 ? "_se" : "_lte";
        i iVar = this.f7546w;
        y(iVar);
        f4 f4VarO2 = iVar.o2(m3Var.V(), str);
        if (f4VarO2 == null || (obj = f4VarO2.f7183e) == null) {
            String strV = m3Var.V();
            y0().getClass();
            f4Var = new f4(strV, "auto", str, System.currentTimeMillis(), Long.valueOf(j5));
        } else {
            String strV2 = m3Var.V();
            y0().getClass();
            f4Var = new f4(strV2, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j5));
        }
        com.google.android.gms.internal.measurement.t3 t3VarZ = com.google.android.gms.internal.measurement.u3.z();
        t3VarZ.e();
        com.google.android.gms.internal.measurement.u3.q((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, str);
        y0().getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        t3VarZ.e();
        com.google.android.gms.internal.measurement.u3.u((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, jCurrentTimeMillis);
        Object obj2 = f4Var.f7183e;
        long jLongValue = ((Long) obj2).longValue();
        t3VarZ.e();
        com.google.android.gms.internal.measurement.u3.p((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, jLongValue);
        com.google.android.gms.internal.measurement.u3 u3Var = (com.google.android.gms.internal.measurement.u3) t3VarZ.c();
        int iW1 = s0.w1(m3Var, str);
        if (iW1 >= 0) {
            m3Var.e();
            com.google.android.gms.internal.measurement.n3.s((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, iW1, u3Var);
        } else {
            m3Var.e();
            com.google.android.gms.internal.measurement.n3.x((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, u3Var);
        }
        if (j5 > 0) {
            i iVar2 = this.f7546w;
            y(iVar2);
            iVar2.a2(f4Var);
            g().I.b(z2 ? "session-scoped" : "lifetime", obj2, "Updated engagement user property. scope, value");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(com.google.android.gms.internal.measurement.m3 r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.o(com.google.android.gms.internal.measurement.m3, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3 A[Catch: all -> 0x0012, TryCatch #0 {all -> 0x0012, blocks: (B:4:0x000f, B:30:0x00a7, B:33:0x00cb, B:12:0x001f, B:14:0x0040, B:15:0x004c, B:17:0x0057, B:20:0x0064, B:21:0x006f, B:22:0x0070, B:24:0x0089, B:26:0x0094, B:28:0x009f, B:29:0x00a3), top: B:38:0x000f, inners: #1 }] */
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
    public final void p(java.lang.String r6, int r7, java.lang.Throwable r8, byte[] r9, k8.d4 r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.p(java.lang.String, int, java.lang.Throwable, byte[], k8.d4):void");
    }

    public final void q(String str, com.google.android.gms.internal.measurement.h3 h3Var, Bundle bundle, String str2) {
        int iMax;
        List listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si"));
        if (h4.u2(((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).C()) || h4.u2(str)) {
            e eVarS = S();
            eVarS.getClass();
            iMax = Math.max(Math.max(Math.min(eVarS.u1(str2, w.U), 500), 100), 256);
        } else {
            e eVarS2 = S();
            eVarS2.getClass();
            iMax = Math.max(Math.min(eVarS2.u1(str2, w.U), 500), 100);
        }
        long j5 = iMax;
        long jCodePointCount = ((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).D().codePointCount(0, ((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).D().length());
        c0();
        String strC = ((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).C();
        S();
        String strD1 = h4.D1(strC, true, 40);
        if (jCodePointCount <= j5 || listUnmodifiableList.contains(((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).C())) {
            return;
        }
        if ("_ev".equals(((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).C())) {
            c0();
            String strD = ((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).D();
            e eVarS3 = S();
            eVarS3.getClass();
            bundle.putString("_ev", h4.D1(strD, true, Math.max(Math.max(Math.min(eVarS3.u1(str2, w.U), 500), 100), 256)));
            return;
        }
        g().F.b(strD1, Long.valueOf(jCodePointCount), "Param value is too long; discarded. Name, value length");
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strD1);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(((com.google.android.gms.internal.measurement.i3) h3Var.f3052v).C());
    }

    public final void r(String str, a4 a4Var) {
        x().p1();
        e0();
        boolean zA0 = a0(a4Var);
        String str2 = a4Var.f7076u;
        if (zA0) {
            if (!a4Var.B) {
                j(a4Var);
                return;
            }
            Boolean boolY = Y(a4Var);
            if ("_npa".equals(str) && boolY != null) {
                g().H.d("Falling back to manifest metadata value for ad personalization");
                y0().getClass();
                z(new e4(System.currentTimeMillis(), Long.valueOf(boolY.booleanValue() ? 1L : 0L), "_npa", "auto"), a4Var);
                return;
            }
            r0 r0Var = g().H;
            k1 k1Var = this.F;
            r0Var.c(k1Var.G.g(str), "Removing user property");
            i iVar = this.f7546w;
            y(iVar);
            iVar.v2();
            try {
                j(a4Var);
                if ("_id".equals(str)) {
                    i iVar2 = this.f7546w;
                    y(iVar2);
                    t7.v.h(str2);
                    iVar2.q2(str2, "_lair");
                }
                i iVar3 = this.f7546w;
                y(iVar3);
                t7.v.h(str2);
                iVar3.q2(str2, str);
                i iVar4 = this.f7546w;
                y(iVar4);
                iVar4.C2();
                g().H.c(k1Var.G.g(str), "User property removed");
                i iVar5 = this.f7546w;
                y(iVar5);
                iVar5.A2();
            } catch (Throwable th) {
                i iVar6 = this.f7546w;
                y(iVar6);
                iVar6.A2();
                throw th;
            }
        }
    }

    public final void s(String str, boolean z2, Long l10, Long l11) {
        i iVar = this.f7546w;
        y(iVar);
        g0 g0VarN2 = iVar.n2(str);
        if (g0VarN2 != null) {
            k1 k1Var = g0VarN2.f7185a;
            h1 h1Var = k1Var.D;
            k1.f(h1Var);
            h1Var.p1();
            g0VarN2.Q |= g0VarN2.f7208z != z2;
            g0VarN2.f7208z = z2;
            h1 h1Var2 = k1Var.D;
            k1.f(h1Var2);
            h1Var2.p1();
            g0VarN2.Q |= !Objects.equals(g0VarN2.A, l10);
            g0VarN2.A = l10;
            h1 h1Var3 = k1Var.D;
            k1.f(h1Var3);
            h1Var3.p1();
            g0VarN2.Q |= !Objects.equals(g0VarN2.B, l11);
            g0VarN2.B = l11;
            if (g0VarN2.n()) {
                i iVar2 = this.f7546w;
                y(iVar2);
                iVar2.V1(g0VarN2, false);
            }
        }
    }

    public final void t(d dVar, a4 a4Var) {
        v vVar = dVar.E;
        t7.v.d(dVar.f7128u);
        t7.v.h(dVar.f7130w);
        t7.v.d(dVar.f7130w.f7164v);
        x().p1();
        e0();
        if (a0(a4Var)) {
            if (!a4Var.B) {
                j(a4Var);
                return;
            }
            i iVar = this.f7546w;
            y(iVar);
            iVar.v2();
            try {
                j(a4Var);
                String str = dVar.f7128u;
                t7.v.h(str);
                i iVar2 = this.f7546w;
                y(iVar2);
                d dVarL2 = iVar2.l2(str, dVar.f7130w.f7164v);
                k1 k1Var = this.F;
                if (dVarL2 != null) {
                    g().H.b(dVar.f7128u, k1Var.G.g(dVar.f7130w.f7164v), "Removing conditional user property");
                    i iVar3 = this.f7546w;
                    y(iVar3);
                    iVar3.Q1(str, dVar.f7130w.f7164v);
                    if (dVarL2.f7132y) {
                        i iVar4 = this.f7546w;
                        y(iVar4);
                        iVar4.q2(str, dVar.f7130w.f7164v);
                    }
                    if (vVar != null) {
                        u uVar = vVar.f7445v;
                        v vVarE1 = c0().E1(vVar.f7444u, uVar != null ? uVar.d() : null, dVarL2.f7129v, vVar.f7447x, true);
                        t7.v.h(vVarE1);
                        P(vVarE1, a4Var);
                    }
                } else {
                    g().D.b(p0.v1(dVar.f7128u), k1Var.G.g(dVar.f7130w.f7164v), "Conditional user property doesn't exist");
                }
                i iVar5 = this.f7546w;
                y(iVar5);
                iVar5.C2();
                i iVar6 = this.f7546w;
                y(iVar6);
                iVar6.A2();
            } catch (Throwable th) {
                i iVar7 = this.f7546w;
                y(iVar7);
                iVar7.A2();
                throw th;
            }
        }
    }

    public final void u(v vVar, String str) {
        i iVar = this.f7546w;
        y(iVar);
        g0 g0VarN2 = iVar.n2(str);
        if (g0VarN2 != null) {
            k1 k1Var = g0VarN2.f7185a;
            if (!TextUtils.isEmpty(g0VarN2.h())) {
                Boolean boolE = e(g0VarN2);
                if (boolE == null) {
                    if (!"_ui".equals(vVar.f7444u)) {
                        g().D.c(p0.v1(str), "Could not find package. appId");
                    }
                } else if (!boolE.booleanValue()) {
                    g().A.c(p0.v1(str), "App version does not match; dropping event. appId");
                    return;
                }
                String strJ = g0VarN2.j();
                String strH = g0VarN2.h();
                long jY = g0VarN2.y();
                h1 h1Var = k1Var.D;
                k1.f(h1Var);
                h1Var.p1();
                String str2 = g0VarN2.f7194l;
                h1 h1Var2 = k1Var.D;
                k1.f(h1Var2);
                h1Var2.p1();
                long j5 = g0VarN2.f7195m;
                h1 h1Var3 = k1Var.D;
                k1.f(h1Var3);
                h1Var3.p1();
                long j8 = g0VarN2.f7196n;
                h1 h1Var4 = k1Var.D;
                k1.f(h1Var4);
                h1Var4.p1();
                boolean z2 = g0VarN2.f7197o;
                String strI = g0VarN2.i();
                h1 h1Var5 = k1Var.D;
                k1.f(h1Var5);
                h1Var5.p1();
                h1 h1Var6 = k1Var.D;
                k1.f(h1Var6);
                h1Var6.p1();
                boolean z10 = g0VarN2.f7198p;
                String strD = g0VarN2.d();
                Boolean boolU = g0VarN2.U();
                long jN = g0VarN2.N();
                h1 h1Var7 = k1Var.D;
                k1.f(h1Var7);
                h1Var7.p1();
                ArrayList arrayList = g0VarN2.f7202t;
                String strM = I(str).m();
                boolean zO = g0VarN2.o();
                h1 h1Var8 = k1Var.D;
                k1.f(h1Var8);
                h1Var8.p1();
                long j10 = g0VarN2.f7205w;
                int i = I(str).f7571b;
                String str3 = Q(str).f7338b;
                h1 h1Var9 = k1Var.D;
                k1.f(h1Var9);
                h1Var9.p1();
                int i10 = g0VarN2.f7207y;
                h1 h1Var10 = k1Var.D;
                k1.f(h1Var10);
                h1Var10.p1();
                L(vVar, new a4(str, strJ, strH, jY, str2, j5, j8, null, z2, false, strI, 0L, 0, z10, false, strD, boolU, jN, arrayList, strM, "", null, zO, j10, i, str3, i10, g0VarN2.C, g0VarN2.l(), g0VarN2.k()));
                return;
            }
        }
        g().H.c(str, "No app data available; dropping event");
    }

    public final void v(v vVar, a4 a4Var) {
        v vVar2;
        List listG1;
        k1 k1Var;
        List<d> listG12;
        List<d> listG13;
        String str;
        t7.v.h(a4Var);
        String str2 = a4Var.f7076u;
        t7.v.d(str2);
        x().p1();
        e0();
        long j5 = vVar.f7447x;
        t0 t0VarD = t0.d(vVar);
        x().p1();
        h4.S1((this.Y == null || (str = this.Z) == null || !str.equals(str2)) ? null : this.Y, (Bundle) t0VarD.f7429e, false);
        v vVarC = t0VarD.c();
        String str3 = vVarC.f7444u;
        b0();
        if (TextUtils.isEmpty(a4Var.f7077v) && TextUtils.isEmpty(a4Var.K)) {
            return;
        }
        if (!a4Var.B) {
            j(a4Var);
            return;
        }
        List list = a4Var.N;
        if (list == null) {
            vVar2 = vVarC;
        } else if (!list.contains(str3)) {
            g().H.e("Dropping non-safelisted event. appId, event name, origin", str2, str3, vVarC.f7446w);
            return;
        } else {
            Bundle bundleD = vVarC.f7445v.d();
            bundleD.putLong("ga_safelisted", 1L);
            vVar2 = new v(vVarC.f7444u, new u(bundleD), vVarC.f7446w, vVarC.f7447x);
        }
        i iVar = this.f7546w;
        y(iVar);
        iVar.v2();
        try {
            i iVar2 = this.f7546w;
            y(iVar2);
            t7.v.d(str2);
            iVar2.p1();
            iVar2.t1();
            if (j5 < 0) {
                iVar2.g().D.b(p0.v1(str2), Long.valueOf(j5), "Invalid time querying timed out conditional properties");
                listG1 = Collections.EMPTY_LIST;
            } else {
                listG1 = iVar2.G1("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j5)});
            }
            Iterator it = listG1.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                k1Var = this.F;
                if (!zHasNext) {
                    break;
                }
                d dVar = (d) it.next();
                if (dVar != null) {
                    g().I.e("User property timed out", dVar.f7128u, k1Var.G.g(dVar.f7130w.f7164v), dVar.f7130w.a());
                    v vVar3 = dVar.A;
                    if (vVar3 != null) {
                        P(new v(vVar3, j5), a4Var);
                    }
                    i iVar3 = this.f7546w;
                    y(iVar3);
                    iVar3.Q1(str2, dVar.f7130w.f7164v);
                }
            }
            i iVar4 = this.f7546w;
            y(iVar4);
            t7.v.d(str2);
            iVar4.p1();
            iVar4.t1();
            if (j5 < 0) {
                iVar4.g().D.b(p0.v1(str2), Long.valueOf(j5), "Invalid time querying expired conditional properties");
                listG12 = Collections.EMPTY_LIST;
            } else {
                listG12 = iVar4.G1("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j5)});
            }
            ArrayList arrayList = new ArrayList(listG12.size());
            for (d dVar2 : listG12) {
                if (dVar2 != null) {
                    g().I.e("User property expired", dVar2.f7128u, k1Var.G.g(dVar2.f7130w.f7164v), dVar2.f7130w.a());
                    i iVar5 = this.f7546w;
                    y(iVar5);
                    iVar5.q2(str2, dVar2.f7130w.f7164v);
                    v vVar4 = dVar2.E;
                    if (vVar4 != null) {
                        arrayList.add(vVar4);
                    }
                    i iVar6 = this.f7546w;
                    y(iVar6);
                    iVar6.Q1(str2, dVar2.f7130w.f7164v);
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                P(new v((v) obj, j5), a4Var);
            }
            i iVar7 = this.f7546w;
            y(iVar7);
            String str4 = vVar2.f7444u;
            t7.v.d(str2);
            t7.v.d(str4);
            iVar7.p1();
            iVar7.t1();
            if (j5 < 0) {
                iVar7.g().D.e("Invalid time querying triggered conditional properties", p0.v1(str2), ((k1) iVar7.f2454v).G.b(str4), Long.valueOf(j5));
                listG13 = Collections.EMPTY_LIST;
            } else {
                listG13 = iVar7.G1("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j5)});
            }
            ArrayList arrayList2 = new ArrayList(listG13.size());
            for (d dVar3 : listG13) {
                if (dVar3 != null) {
                    e4 e4Var = dVar3.f7130w;
                    String str5 = dVar3.f7128u;
                    t7.v.h(str5);
                    String str6 = dVar3.f7129v;
                    String str7 = e4Var.f7164v;
                    Object objA = e4Var.a();
                    t7.v.h(objA);
                    f4 f4Var = new f4(str5, str6, str7, j5, objA);
                    Object obj2 = f4Var.f7183e;
                    String str8 = f4Var.f7181c;
                    i iVar8 = this.f7546w;
                    y(iVar8);
                    if (iVar8.a2(f4Var)) {
                        g().I.e("User property triggered", dVar3.f7128u, k1Var.G.g(str8), obj2);
                    } else {
                        g().A.e("Too many active user properties, ignoring", p0.v1(dVar3.f7128u), k1Var.G.g(str8), obj2);
                    }
                    v vVar5 = dVar3.C;
                    if (vVar5 != null) {
                        arrayList2.add(vVar5);
                    }
                    dVar3.f7130w = new e4(f4Var);
                    dVar3.f7132y = true;
                    i iVar9 = this.f7546w;
                    y(iVar9);
                    iVar9.Z1(dVar3);
                }
            }
            P(vVar2, a4Var);
            int size2 = arrayList2.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj3 = arrayList2.get(i10);
                i10++;
                P(new v((v) obj3, j5), a4Var);
            }
            i iVar10 = this.f7546w;
            y(iVar10);
            iVar10.C2();
            i iVar11 = this.f7546w;
            y(iVar11);
            iVar11.A2();
        } catch (Throwable th) {
            i iVar12 = this.f7546w;
            y(iVar12);
            iVar12.A2();
            throw th;
        }
    }

    public final void w(g0 g0Var, com.google.android.gms.internal.measurement.m3 m3Var) {
        rc.b bVar;
        com.google.android.gms.internal.measurement.u3 u3Var;
        h hVar;
        x().p1();
        e0();
        String strE = ((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).E();
        EnumMap enumMap = new EnumMap(y1.class);
        int length = strE.length();
        int length2 = y1.values().length;
        h hVar2 = h.UNSET;
        int i = 0;
        if (length < length2 || strE.charAt(0) != '1') {
            bVar = new rc.b(17);
        } else {
            y1[] y1VarArrValues = y1.values();
            int length3 = y1VarArrValues.length;
            int i10 = 0;
            int i11 = 1;
            while (i10 < length3) {
                y1 y1Var = y1VarArrValues[i10];
                int i12 = i11 + 1;
                char cCharAt = strE.charAt(i11);
                h[] hVarArrValues = h.values();
                int length4 = hVarArrValues.length;
                int i13 = i;
                while (true) {
                    if (i13 >= length4) {
                        hVar = hVar2;
                        break;
                    }
                    hVar = hVarArrValues[i13];
                    if (hVar.f7223u == cCharAt) {
                        break;
                    } else {
                        i13++;
                    }
                }
                enumMap.put(y1Var, hVar);
                i10++;
                i11 = i12;
                i = 0;
            }
            bVar = new rc.b(enumMap);
        }
        String strF = g0Var.f();
        x().p1();
        e0();
        z1 z1VarI = I(strF);
        EnumMap enumMap2 = z1VarI.f7570a;
        int[] iArr = b4.f7101a;
        y1 y1Var2 = y1.f7554v;
        b2 b2Var = (b2) enumMap2.get(y1Var2);
        b2 b2Var2 = b2.f7089v;
        if (b2Var == null) {
            b2Var = b2Var2;
        }
        int i14 = z1VarI.f7571b;
        int i15 = iArr[b2Var.ordinal()];
        h hVar3 = h.REMOTE_ENFORCED_DEFAULT;
        h hVar4 = h.FAILSAFE;
        if (i15 == 1) {
            bVar.M(y1Var2, hVar3);
        } else if (i15 == 2 || i15 == 3) {
            bVar.L(y1Var2, i14);
        } else {
            bVar.M(y1Var2, hVar4);
        }
        y1 y1Var3 = y1.f7555w;
        b2 b2Var3 = (b2) enumMap2.get(y1Var3);
        if (b2Var3 != null) {
            b2Var2 = b2Var3;
        }
        int i16 = iArr[b2Var2.ordinal()];
        if (i16 == 1) {
            bVar.M(y1Var3, hVar3);
        } else if (i16 == 2 || i16 == 3) {
            bVar.L(y1Var3, i14);
        } else {
            bVar.M(y1Var3, hVar4);
        }
        String strF2 = g0Var.f();
        x().p1();
        e0();
        o oVarI = i(strF2, Q(strF2), I(strF2), bVar);
        String str = oVarI.f7340d;
        Boolean bool = oVarI.f7339c;
        t7.v.h(bool);
        boolean zBooleanValue = bool.booleanValue();
        m3Var.e();
        com.google.android.gms.internal.measurement.n3.i0((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, zBooleanValue);
        if (!TextUtils.isEmpty(str)) {
            m3Var.e();
            com.google.android.gms.internal.measurement.n3.q1((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, str);
        }
        x().p1();
        e0();
        Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.n3) m3Var.f3052v).T()).iterator();
        while (true) {
            if (it.hasNext()) {
                u3Var = (com.google.android.gms.internal.measurement.u3) it.next();
                if ("_npa".equals(u3Var.A())) {
                    break;
                }
            } else {
                u3Var = null;
                break;
            }
        }
        if (u3Var != null) {
            EnumMap enumMap3 = (EnumMap) bVar.f11562v;
            y1 y1Var4 = y1.f7557y;
            h hVar5 = (h) enumMap3.get(y1Var4);
            if (hVar5 == null) {
                hVar5 = hVar2;
            }
            if (hVar5 == hVar2) {
                i iVar = this.f7546w;
                y(iVar);
                f4 f4VarO2 = iVar.o2(g0Var.f(), "_npa");
                h hVar6 = h.MANIFEST;
                h hVar7 = h.API;
                if (f4VarO2 != null) {
                    String str2 = f4VarO2.f7180b;
                    if ("tcf".equals(str2)) {
                        bVar.M(y1Var4, h.TCF);
                    } else if ("app".equals(str2)) {
                        bVar.M(y1Var4, hVar7);
                    } else {
                        bVar.M(y1Var4, hVar6);
                    }
                } else {
                    Boolean boolU = g0Var.U();
                    if (boolU == null || ((boolU == Boolean.TRUE && u3Var.w() != 1) || (boolU == Boolean.FALSE && u3Var.w() != 0))) {
                        bVar.M(y1Var4, hVar7);
                    } else {
                        bVar.M(y1Var4, hVar6);
                    }
                }
            }
        } else {
            int iC = c(g0Var.f(), bVar);
            com.google.android.gms.internal.measurement.t3 t3VarZ = com.google.android.gms.internal.measurement.u3.z();
            t3VarZ.e();
            com.google.android.gms.internal.measurement.u3.q((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, "_npa");
            y0().getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            t3VarZ.e();
            com.google.android.gms.internal.measurement.u3.u((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, jCurrentTimeMillis);
            t3VarZ.e();
            com.google.android.gms.internal.measurement.u3.p((com.google.android.gms.internal.measurement.u3) t3VarZ.f3052v, iC);
            com.google.android.gms.internal.measurement.u3 u3Var2 = (com.google.android.gms.internal.measurement.u3) t3VarZ.c();
            m3Var.e();
            com.google.android.gms.internal.measurement.n3.x((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, u3Var2);
            g().I.b("non_personalized_ads(_npa)", Integer.valueOf(iC), "Setting user property");
        }
        String string = bVar.toString();
        m3Var.e();
        com.google.android.gms.internal.measurement.n3.g1((com.google.android.gms.internal.measurement.n3) m3Var.f3052v, string);
        String strF3 = g0Var.f();
        d1 d1Var = this.f7544u;
        d1Var.p1();
        d1Var.N1(strF3);
        com.google.android.gms.internal.measurement.i2 i2VarF1 = d1Var.F1(strF3);
        boolean z2 = i2VarF1 == null || !i2VarF1.t() || i2VarF1.s();
        List listN = m3Var.n();
        for (int i17 = 0; i17 < listN.size(); i17++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.f3) listN.get(i17)).B())) {
                com.google.android.gms.internal.measurement.e3 e3Var = (com.google.android.gms.internal.measurement.e3) ((com.google.android.gms.internal.measurement.f3) listN.get(i17)).k();
                List listM = e3Var.m();
                int i18 = 0;
                while (true) {
                    if (i18 >= listM.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.i3) listM.get(i18)).C())) {
                        String strD = ((com.google.android.gms.internal.measurement.i3) listM.get(i18)).D();
                        if (z2 && strD.length() > 4) {
                            char[] charArray = strD.toCharArray();
                            int i19 = 1;
                            while (true) {
                                if (i19 >= 64) {
                                    i19 = 0;
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i19)) {
                                    break;
                                } else {
                                    i19++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i19 | 1);
                            strD = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.h3 h3VarB = com.google.android.gms.internal.measurement.i3.B();
                        h3VarB.h("_tcfd");
                        h3VarB.i(strD);
                        e3Var.e();
                        com.google.android.gms.internal.measurement.f3.s((com.google.android.gms.internal.measurement.f3) e3Var.f3052v, i18, (com.google.android.gms.internal.measurement.i3) h3VarB.c());
                    } else {
                        i18++;
                    }
                }
                m3Var.g(i17, e3Var);
                return;
            }
        }
    }

    @Override // k8.w1
    public final h1 x() {
        k1 k1Var = this.F;
        t7.v.h(k1Var);
        h1 h1Var = k1Var.D;
        k1.f(h1Var);
        return h1Var;
    }

    @Override // k8.w1
    public final x7.a y0() {
        k1 k1Var = this.F;
        t7.v.h(k1Var);
        return k1Var.H;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(k8.e4 r26, k8.a4 r27) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.x3.z(k8.e4, k8.a4):void");
    }
}
