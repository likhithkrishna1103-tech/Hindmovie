package ta;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;
import wa.a0;
import wa.b0;
import wa.h1;
import wa.i0;
import wa.j0;
import wa.k0;
import wa.k1;
import wa.l1;
import wa.m0;
import wa.m1;
import wa.m2;
import wa.n1;
import wa.n2;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f12380r = new g(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2.p f12382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p2.c f12383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final za.c f12384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ua.d f12385e;
    public final v f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final za.c f12386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final dd.h f12387h;
    public final va.f i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qa.a f12388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ra.a f12389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f12390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b2.g f12391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s f12392n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o8.h f12393o = new o8.h();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final o8.h f12394p = new o8.h();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final o8.h f12395q = new o8.h();

    public m(Context context, v vVar, o2.p pVar, za.c cVar, p2.c cVar2, dd.h hVar, za.c cVar3, va.f fVar, b2.g gVar, qa.a aVar, ra.a aVar2, i iVar, ua.d dVar) {
        new AtomicBoolean(false);
        this.f12381a = context;
        this.f = vVar;
        this.f12382b = pVar;
        this.f12386g = cVar;
        this.f12383c = cVar2;
        this.f12387h = hVar;
        this.f12384d = cVar3;
        this.i = fVar;
        this.f12388j = aVar;
        this.f12389k = aVar2;
        this.f12390l = iVar;
        this.f12391m = gVar;
        this.f12385e = dVar;
    }

    public static o8.o a(m mVar) {
        o8.o oVarF;
        mVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (File file : za.c.e(((File) mVar.f12386g.f14936c).listFiles(f12380r))) {
            try {
                long j5 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    Log.w("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                    oVarF = t1.k(null);
                } catch (ClassNotFoundException unused) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Logging app exception event to Firebase Analytics", null);
                    }
                    oVarF = t1.f(new ScheduledThreadPoolExecutor(1), new l(mVar, j5));
                }
                arrayList.add(oVarF);
            } catch (NumberFormatException unused2) {
                Log.w("FirebaseCrashlytics", "Could not parse app exception timestamp from file " + file.getName(), null);
            }
            file.delete();
        }
        return t1.x(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() throws java.io.IOException {
        /*
            java.lang.Class<ta.m> r0 = ta.m.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "FirebaseCrashlytics"
            r2 = 0
            if (r0 != 0) goto L12
            java.lang.String r0 = "Couldn't get Class Loader"
            android.util.Log.w(r1, r0, r2)
        L10:
            r0 = r2
            goto L20
        L12:
            java.lang.String r3 = "META-INF/version-control-info.textproto"
            java.io.InputStream r0 = r0.getResourceAsStream(r3)
            if (r0 != 0) goto L20
            java.lang.String r0 = "No version control information found"
            android.util.Log.i(r1, r0, r2)
            goto L10
        L20:
            if (r0 != 0) goto L23
            return r2
        L23:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r1, r3)
            if (r3 == 0) goto L2f
            java.lang.String r3 = "Read version control info"
            android.util.Log.d(r1, r3, r2)
        L2f:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]
        L38:
            int r3 = r0.read(r2)
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L44
            r1.write(r2, r5, r3)
            goto L38
        L44:
            byte[] r0 = r1.toByteArray()
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ta.m.e():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:194:0x05cb  */
    /* JADX WARN: Type inference failed for: r0v6, types: [ta.i] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [int] */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r33v0, types: [boolean] */
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
    public final void b(boolean r33, b7.s r34, boolean r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ta.m.b(boolean, b7.s, boolean):void");
    }

    public final void c(String str, Boolean bool) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        Integer num;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strM = l4.a.m("Opening a new session with ID ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", strM, null);
        }
        Locale locale = Locale.US;
        v vVar = this.f;
        dd.h hVar = this.f12387h;
        l1 l1Var = new l1(vVar.f12436c, (String) hVar.f, (String) hVar.f4156g, vVar.c().f12351a, e6.j.e(((String) hVar.f4154d) != null ? 4 : 1), (pb.c) hVar.f4157h);
        String str6 = Build.VERSION.RELEASE;
        String str7 = Build.VERSION.CODENAME;
        n1 n1Var = new n1(f.g());
        Context context = this.f12381a;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        e eVar = e.f12360u;
        String str8 = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str8)) {
            e eVar2 = (e) e.f12361v.get(str8.toLowerCase(locale));
            if (eVar2 != null) {
                eVar = eVar2;
            }
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty", null);
        }
        int iOrdinal = eVar.ordinal();
        String str9 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jA = f.a(context);
        boolean zF = f.f();
        int iC = f.c();
        String str10 = Build.MANUFACTURER;
        String str11 = Build.PRODUCT;
        this.f12388j.d(str, jCurrentTimeMillis, new k1(l1Var, n1Var, new m1(iOrdinal, iAvailableProcessors, jA, blockCount, zF, iC)));
        if (!bool.booleanValue() || str == null) {
            str2 = str7;
            str3 = str10;
            str4 = str11;
            str5 = str9;
            i = 4;
        } else {
            za.c cVar = this.f12384d;
            synchronized (((String) cVar.f14934a)) {
                cVar.f14934a = str;
                str4 = str11;
                str5 = str9;
                str2 = str7;
                str3 = str10;
                i = 4;
                ((ua.d) cVar.f14936c).f12824b.a(new c2.w(cVar, str, ((va.d) ((AtomicMarkableReference) ((a2.c) cVar.f14937d).f173v).getReference()).a(), ((va.o) cVar.f).a(), 10));
            }
        }
        va.f fVar = this.i;
        ((va.c) fVar.f13443v).a();
        fVar.f13443v = va.f.f13441w;
        if (str != null) {
            fVar.f13443v = new va.m(((za.c) fVar.f13442u).b(str, "userlog"));
        }
        this.f12390l.a(str);
        b2.g gVar = this.f12391m;
        r rVar = (r) gVar.f1737b;
        Charset charset = n2.f13975a;
        a0 a0Var = new a0();
        a0Var.f13764a = "19.2.0";
        dd.h hVar2 = rVar.f12420c;
        String str12 = (String) hVar2.f4151a;
        if (str12 == null) {
            throw new NullPointerException("Null gmpAppId");
        }
        a0Var.f13765b = str12;
        v vVar2 = rVar.f12419b;
        String str13 = vVar2.c().f12351a;
        if (str13 == null) {
            throw new NullPointerException("Null installationUuid");
        }
        a0Var.f13767d = str13;
        a0Var.f13768e = vVar2.c().f12352b;
        a0Var.f = vVar2.c().f12353c;
        String str14 = (String) hVar2.f;
        if (str14 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        a0Var.f13770h = str14;
        String str15 = (String) hVar2.f4156g;
        if (str15 == null) {
            throw new NullPointerException("Null displayVersion");
        }
        a0Var.i = str15;
        a0Var.f13766c = i;
        a0Var.f13774m = (byte) (a0Var.f13774m | 1);
        i0 i0Var = new i0();
        i0Var.f = false;
        byte b10 = (byte) (i0Var.f13892m | 2);
        i0Var.f13885d = jCurrentTimeMillis;
        i0Var.f13892m = (byte) (b10 | 1);
        if (str == null) {
            throw new NullPointerException("Null identifier");
        }
        i0Var.f13883b = str;
        String str16 = r.f12417g;
        if (str16 == null) {
            throw new NullPointerException("Null generator");
        }
        i0Var.f13882a = str16;
        String str17 = vVar2.f12436c;
        if (str17 == null) {
            throw new NullPointerException("Null identifier");
        }
        String str18 = vVar2.c().f12351a;
        pb.c cVar2 = (pb.c) hVar2.f4157h;
        if (((p2.c) cVar2.f10311w) == null) {
            cVar2.f10311w = new p2.c(cVar2);
        }
        p2.c cVar3 = (p2.c) cVar2.f10311w;
        String str19 = (String) cVar3.f10130v;
        if (cVar3 == null) {
            cVar2.f10311w = new p2.c(cVar2);
        }
        i0Var.f13887g = new k0(str17, str14, str15, str18, str19, (String) ((p2.c) cVar2.f10311w).f10131w);
        h1 h1Var = new h1();
        h1Var.f13869a = 3;
        h1Var.f13873e = (byte) (h1Var.f13873e | 1);
        if (str6 == null) {
            throw new NullPointerException("Null version");
        }
        h1Var.f13870b = str6;
        if (str2 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        h1Var.f13871c = str2;
        h1Var.f13872d = f.g();
        h1Var.f13873e = (byte) (h1Var.f13873e | 2);
        i0Var.i = h1Var.a();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str8) && (num = (Integer) r.f.get(str8.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jA2 = f.a(rVar.f12418a);
        long blockCount2 = ((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize());
        boolean zF2 = f.f();
        int iC2 = f.c();
        m0 m0Var = new m0();
        m0Var.f13949a = iIntValue;
        byte b11 = (byte) (m0Var.f13956j | 1);
        m0Var.f13956j = b11;
        if (str5 == null) {
            throw new NullPointerException("Null model");
        }
        m0Var.f13950b = str5;
        m0Var.f13951c = iAvailableProcessors2;
        m0Var.f13952d = jA2;
        m0Var.f13953e = blockCount2;
        m0Var.f = zF2;
        m0Var.f13954g = iC2;
        m0Var.f13956j = (byte) (((byte) (((byte) (((byte) (((byte) (b11 | 2)) | 4)) | 8)) | 16)) | 32);
        String str20 = str3;
        if (str20 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        m0Var.f13955h = str20;
        String str21 = str4;
        if (str21 == null) {
            throw new NullPointerException("Null modelClass");
        }
        m0Var.i = str21;
        i0Var.f13889j = m0Var.a();
        i0Var.f13891l = 3;
        i0Var.f13892m = (byte) (i0Var.f13892m | 4);
        a0Var.f13771j = i0Var.a();
        b0 b0VarA = a0Var.a();
        za.c cVar4 = ((za.a) gVar.f1738c).f14930b;
        m2 m2Var = b0VarA.f13796k;
        if (m2Var == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not get session for report", null);
                return;
            }
            return;
        }
        String str22 = ((j0) m2Var).f13909b;
        try {
            za.a.f14927g.getClass();
            za.a.f(cVar4.b(str22, "report"), xa.a.f14333a.I(b0VarA));
            File fileB = cVar4.b(str22, "start-time");
            long j5 = ((j0) m2Var).f13911d;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileB), za.a.f14926e);
            try {
                outputStreamWriter.write("");
                fileB.setLastModified(j5 * 1000);
                outputStreamWriter.close();
            } finally {
            }
        } catch (IOException e10) {
            String strM2 = l4.a.m("Could not persist report for session ", str22);
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", strM2, e10);
            }
        }
    }

    public final boolean d(b7.s sVar) throws Throwable {
        ua.d.a();
        s sVar2 = this.f12392n;
        if (sVar2 != null && sVar2.f12427e.get()) {
            Log.w("FirebaseCrashlytics", "Skipping session finalization because a crash has already occurred.", null);
            return false;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Finalizing previously open sessions.", null);
        }
        try {
            b(true, sVar, true);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Closed all previously open sessions.", null);
            }
            return true;
        } catch (Exception e10) {
            Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e10);
            return false;
        }
    }

    public final void f() {
        try {
            String strE = e();
            if (strE != null) {
                try {
                    this.f12384d.f(strE);
                } catch (IllegalArgumentException e10) {
                    Context context = this.f12381a;
                    if (context != null && (context.getApplicationInfo().flags & 2) != 0) {
                        throw e10;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                }
                Log.i("FirebaseCrashlytics", "Saved version control info", null);
            }
        } catch (IOException e11) {
            Log.w("FirebaseCrashlytics", "Unable to save version control info", e11);
        }
    }

    public final void g(o8.o oVar) {
        o8.o oVar2;
        o8.o oVarA;
        o8.h hVar = this.f12393o;
        za.c cVar = ((za.a) this.f12391m.f1738c).f14930b;
        if (za.c.e(((File) cVar.f14938e).listFiles()).isEmpty() && za.c.e(((File) cVar.f).listFiles()).isEmpty() && za.c.e(((File) cVar.f14939g).listFiles()).isEmpty()) {
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "No crash reports are available to be sent.", null);
            }
            hVar.c(Boolean.FALSE);
            return;
        }
        qa.c cVar2 = qa.c.f11167a;
        cVar2.e("Crash reports are available to be sent.");
        o2.p pVar = this.f12382b;
        if (pVar.a()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Automatic data collection is enabled. Allowing upload.", null);
            }
            hVar.c(Boolean.FALSE);
            oVarA = t1.k(Boolean.TRUE);
        } else {
            cVar2.b("Automatic data collection is disabled.");
            cVar2.e("Notifying that unsent reports are available.");
            hVar.c(Boolean.TRUE);
            synchronized (pVar.f9186w) {
                oVar2 = ((o8.h) pVar.f9187x).f9421a;
            }
            k8.b0 b0Var = new k8.b0(28);
            oVar2.getClass();
            c7.r rVar = o8.i.f9422a;
            o8.o oVar3 = new o8.o();
            oVar2.f9440b.i(new o8.m(rVar, b0Var, oVar3));
            oVar2.q();
            cVar2.b("Waiting for send/deleteUnsentReports to be called.");
            oVarA = ua.a.a(oVar3, this.f12394p.f9421a);
        }
        oVarA.k(this.f12385e.f12823a, new pb.c(11, this, oVar, false));
    }
}
