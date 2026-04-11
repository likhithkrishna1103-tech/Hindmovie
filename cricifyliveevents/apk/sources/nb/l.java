package nb;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import f9.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;
import qb.a0;
import qb.b0;
import qb.h1;
import qb.i0;
import qb.j0;
import qb.k0;
import qb.k1;
import qb.l1;
import qb.m0;
import qb.m1;
import qb.m2;
import qb.n1;
import qb.n2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final g f8953r = new g(1);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Charset f8954s = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n8.k f8956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.k f8957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tb.c f8958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ob.c f8959e;
    public final v f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final tb.c f8960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hd.e f8961h;
    public final pb.e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kb.a f8962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final lb.a f8963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f8964l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c2.o f8965m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r f8966n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j9.i f8967o = new j9.i();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j9.i f8968p = new j9.i();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j9.i f8969q = new j9.i();

    public l(Context context, v vVar, n8.k kVar, tb.c cVar, i2.k kVar2, hd.e eVar, tb.c cVar2, pb.e eVar2, c2.o oVar, kb.a aVar, lb.a aVar2, i iVar, ob.c cVar3) {
        new AtomicBoolean(false);
        this.f8955a = context;
        this.f = vVar;
        this.f8956b = kVar;
        this.f8960g = cVar;
        this.f8957c = kVar2;
        this.f8961h = eVar;
        this.f8958d = cVar2;
        this.i = eVar2;
        this.f8962j = aVar;
        this.f8963k = aVar2;
        this.f8964l = iVar;
        this.f8965m = oVar;
        this.f8959e = cVar3;
    }

    public static j9.p a(l lVar) {
        j9.p pVarE;
        lVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (File file : tb.c.e(((File) lVar.f8960g.f11985x).listFiles(f8953r))) {
            try {
                long j4 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    Log.w("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                    pVarE = vf.g.A(null);
                } catch (ClassNotFoundException unused) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Logging app exception event to Firebase Analytics", null);
                    }
                    pVarE = vf.g.e(new ScheduledThreadPoolExecutor(1), new k(lVar, j4));
                }
                arrayList.add(pVarE);
            } catch (NumberFormatException unused2) {
                Log.w("FirebaseCrashlytics", "Could not parse app exception timestamp from file " + file.getName(), null);
            }
            file.delete();
        }
        return vf.g.b0(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05c0  */
    /* JADX WARN: Type inference failed for: r0v6, types: [nb.i] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26, types: [int] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
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
    public final void b(boolean r33, d8.j r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1933
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.l.b(boolean, d8.j, boolean):void");
    }

    public final void c(String str, Boolean bool) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        Integer num;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strN = q4.a.n("Opening a new session with ID ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", strN, null);
        }
        Locale locale = Locale.US;
        v vVar = this.f;
        hd.e eVar = this.f8961h;
        l1 l1Var = new l1(vVar.f9012c, (String) eVar.f, (String) eVar.f5930g, vVar.c().f8925a, l0.e.c(((String) eVar.f5928d) != null ? 4 : 1), (i2.k) eVar.f5931h);
        String str6 = Build.VERSION.RELEASE;
        String str7 = Build.VERSION.CODENAME;
        n1 n1Var = new n1(f.g());
        Context context = this.f8955a;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        e eVar2 = e.f8934v;
        String str8 = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str8)) {
            e eVar3 = (e) e.f8935w.get(str8.toLowerCase(locale));
            if (eVar3 != null) {
                eVar2 = eVar3;
            }
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty", null);
        }
        int iOrdinal = eVar2.ordinal();
        String str9 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jA = f.a(context);
        boolean zF = f.f();
        int iC = f.c();
        String str10 = Build.MANUFACTURER;
        String str11 = Build.PRODUCT;
        this.f8962j.d(str, jCurrentTimeMillis, new k1(l1Var, n1Var, new m1(iOrdinal, iAvailableProcessors, jA, blockCount, zF, iC)));
        if (!bool.booleanValue() || str == null) {
            str2 = str7;
            str3 = str10;
            str4 = str11;
            str5 = str9;
            i = 4;
        } else {
            tb.c cVar = this.f8958d;
            synchronized (((String) cVar.f11983v)) {
                cVar.f11983v = str;
                str4 = str11;
                str5 = str9;
                str2 = str7;
                str3 = str10;
                i = 4;
                ((ob.c) cVar.f11985x).f9743b.a(new c8.a(cVar, str, ((pb.d) ((AtomicMarkableReference) ((com.bumptech.glide.l) cVar.f11986y).f2223w).getReference()).a(), ((of.t) cVar.A).a(), 8));
            }
        }
        pb.e eVar4 = this.i;
        ((pb.c) eVar4.f10157w).b();
        eVar4.f10157w = pb.e.f10155x;
        if (str != null) {
            eVar4.f10157w = new pb.l(((tb.c) eVar4.f10156v).b(str, "userlog"));
        }
        this.f8964l.a(str);
        c2.o oVar = this.f8965m;
        q qVar = (q) oVar.f2035b;
        Charset charset = n2.f10678a;
        a0 a0Var = new a0();
        a0Var.f10467a = "20.0.4";
        hd.e eVar5 = qVar.f8994c;
        String str12 = (String) eVar5.f5925a;
        if (str12 == null) {
            throw new NullPointerException("Null gmpAppId");
        }
        a0Var.f10468b = str12;
        v vVar2 = qVar.f8993b;
        String str13 = vVar2.c().f8925a;
        if (str13 == null) {
            throw new NullPointerException("Null installationUuid");
        }
        a0Var.f10470d = str13;
        a0Var.f10471e = vVar2.c().f8926b;
        a0Var.f = vVar2.c().f8927c;
        String str14 = (String) eVar5.f;
        if (str14 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        a0Var.f10473h = str14;
        String str15 = (String) eVar5.f5930g;
        if (str15 == null) {
            throw new NullPointerException("Null displayVersion");
        }
        a0Var.i = str15;
        a0Var.f10469c = i;
        a0Var.f10477m = (byte) (a0Var.f10477m | 1);
        i0 i0Var = new i0();
        i0Var.f = false;
        byte b8 = (byte) (i0Var.f10595m | 2);
        i0Var.f10588d = jCurrentTimeMillis;
        i0Var.f10595m = (byte) (b8 | 1);
        if (str == null) {
            throw new NullPointerException("Null identifier");
        }
        i0Var.f10586b = str;
        String str16 = q.f8991g;
        if (str16 == null) {
            throw new NullPointerException("Null generator");
        }
        i0Var.f10585a = str16;
        String str17 = vVar2.f9012c;
        if (str17 == null) {
            throw new NullPointerException("Null identifier");
        }
        String str18 = vVar2.c().f8925a;
        i2.k kVar = (i2.k) eVar5.f5931h;
        if (((k2.u) kVar.f6086w) == null) {
            kVar.f6086w = new k2.u(kVar);
        }
        k2.u uVar = (k2.u) kVar.f6086w;
        String str19 = uVar.f6898b;
        if (uVar == null) {
            kVar.f6086w = new k2.u(kVar);
        }
        i0Var.f10590g = new k0(str17, str14, str15, str18, str19, ((k2.u) kVar.f6086w).f6899c);
        h1 h1Var = new h1();
        h1Var.f10572a = 3;
        h1Var.f10576e = (byte) (h1Var.f10576e | 1);
        if (str6 == null) {
            throw new NullPointerException("Null version");
        }
        h1Var.f10573b = str6;
        if (str2 == null) {
            throw new NullPointerException("Null buildVersion");
        }
        h1Var.f10574c = str2;
        h1Var.f10575d = f.g();
        h1Var.f10576e = (byte) (h1Var.f10576e | 2);
        i0Var.i = h1Var.a();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str8) && (num = (Integer) q.f.get(str8.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jA2 = f.a(qVar.f8992a);
        long blockCount2 = ((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize());
        boolean zF2 = f.f();
        int iC2 = f.c();
        m0 m0Var = new m0();
        m0Var.f10652a = iIntValue;
        byte b10 = (byte) (m0Var.f10659j | 1);
        m0Var.f10659j = b10;
        if (str5 == null) {
            throw new NullPointerException("Null model");
        }
        m0Var.f10653b = str5;
        m0Var.f10654c = iAvailableProcessors2;
        m0Var.f10655d = jA2;
        m0Var.f10656e = blockCount2;
        m0Var.f = zF2;
        m0Var.f10657g = iC2;
        m0Var.f10659j = (byte) (((byte) (((byte) (((byte) (((byte) (b10 | 2)) | 4)) | 8)) | 16)) | 32);
        String str20 = str3;
        if (str20 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        m0Var.f10658h = str20;
        String str21 = str4;
        if (str21 == null) {
            throw new NullPointerException("Null modelClass");
        }
        m0Var.i = str21;
        i0Var.f10592j = m0Var.a();
        i0Var.f10594l = 3;
        i0Var.f10595m = (byte) (i0Var.f10595m | 4);
        a0Var.f10474j = i0Var.a();
        b0 b0VarA = a0Var.a();
        tb.c cVar2 = ((tb.a) oVar.f2036c).f11979b;
        m2 m2Var = b0VarA.f10499k;
        if (m2Var == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not get session for report", null);
                return;
            }
            return;
        }
        String str22 = ((j0) m2Var).f10612b;
        try {
            tb.a.f11976g.getClass();
            tb.a.f(cVar2.b(str22, "report"), rb.a.f10920a.g(b0VarA));
            File fileB = cVar2.b(str22, "start-time");
            long j4 = ((j0) m2Var).f10614d;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileB), tb.a.f11975e);
            try {
                outputStreamWriter.write("");
                fileB.setLastModified(j4 * 1000);
                outputStreamWriter.close();
            } finally {
            }
        } catch (IOException e9) {
            String strN2 = q4.a.n("Could not persist report for session ", str22);
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", strN2, e9);
            }
        }
    }

    public final boolean d(d8.j jVar) {
        ob.c.a();
        r rVar = this.f8966n;
        if (rVar != null && rVar.f9001e.get()) {
            Log.w("FirebaseCrashlytics", "Skipping session finalization because a crash has already occurred.", null);
            return false;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Finalizing previously open sessions.", null);
        }
        try {
            b(true, jVar, true);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Closed all previously open sessions.", null);
            }
            return true;
        } catch (Exception e9) {
            Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e9);
            return false;
        }
    }

    public final String e() throws IOException {
        InputStream resourceAsStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Context context = this.f8955a;
        int iD = f.d(context, "com.google.firebase.crashlytics.version_control_info", "string");
        String string = iD == 0 ? null : context.getResources().getString(iD);
        if (string != null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Read version control info from string resource", null);
            }
            return Base64.encodeToString(string.getBytes(f8954s), 0);
        }
        ClassLoader classLoader = l.class.getClassLoader();
        if (classLoader == null) {
            Log.w("FirebaseCrashlytics", "Couldn't get Class Loader", null);
            resourceAsStream = null;
        } else {
            resourceAsStream = classLoader.getResourceAsStream("META-INF/version-control-info.textproto");
        }
        if (resourceAsStream == null) {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            Log.i("FirebaseCrashlytics", "No version control information found", null);
            return null;
        }
        try {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Read version control info from file", null);
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bArr = new byte[1024];
            } finally {
            }
        } catch (Throwable th) {
            try {
                resourceAsStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        while (true) {
            int i = resourceAsStream.read(bArr);
            if (i == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                String strEncodeToString = Base64.encodeToString(byteArray, 0);
                resourceAsStream.close();
                return strEncodeToString;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            resourceAsStream.close();
            throw th;
        }
    }

    public final void f() {
        try {
            String strE = e();
            if (strE != null) {
                try {
                    this.f8958d.f(strE);
                } catch (IllegalArgumentException e9) {
                    Context context = this.f8955a;
                    if (context != null && (context.getApplicationInfo().flags & 2) != 0) {
                        throw e9;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                }
                Log.i("FirebaseCrashlytics", "Saved version control info", null);
            }
        } catch (IOException e10) {
            Log.w("FirebaseCrashlytics", "Unable to save version control info", e10);
        }
    }

    public final void g(j9.p pVar) {
        j9.p pVar2;
        j9.p pVarA;
        j9.i iVar = this.f8967o;
        tb.c cVar = ((tb.a) this.f8965m.f2036c).f11979b;
        if (tb.c.e(((File) cVar.f11987z).listFiles()).isEmpty() && tb.c.e(((File) cVar.A).listFiles()).isEmpty() && tb.c.e(((File) cVar.B).listFiles()).isEmpty()) {
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "No crash reports are available to be sent.", null);
            }
            iVar.c(Boolean.FALSE);
            return;
        }
        kb.c cVar2 = kb.c.f7396a;
        cVar2.e("Crash reports are available to be sent.");
        n8.k kVar = this.f8956b;
        if (kVar.a()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Automatic data collection is enabled. Allowing upload.", null);
            }
            iVar.c(Boolean.FALSE);
            pVarA = vf.g.A(Boolean.TRUE);
        } else {
            cVar2.b("Automatic data collection is disabled.");
            cVar2.e("Notifying that unsent reports are available.");
            iVar.c(Boolean.TRUE);
            synchronized (kVar.f8886x) {
                pVar2 = ((j9.i) kVar.f8887y).f6688a;
            }
            z zVar = new z(19);
            pVar2.getClass();
            f9.m2 m2Var = j9.j.f6689a;
            j9.p pVar3 = new j9.p();
            pVar2.f6707b.h(new j9.n(m2Var, zVar, pVar3));
            pVar2.q();
            cVar2.b("Waiting for send/deleteUnsentReports to be called.");
            pVarA = ob.a.a(pVar3, this.f8968p.f6688a);
        }
        pVarA.k(this.f8959e.f9742a, new i2.k(this, pVar, false));
    }
}
