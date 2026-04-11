package pb;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowInsetsAnimation;
import bc.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k8.c0;
import o2.i0;
import o8.g;
import o8.h;
import o8.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.r1;
import q3.e;
import q4.f1;
import q7.i;
import t7.v;
import ta.m;
import ta.p;
import v1.n;
import wa.t1;
import x6.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements o8.c, g, v1.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f10311w;

    public /* synthetic */ c(int i, Object obj, Object obj2, boolean z2) {
        this.f10309u = i;
        this.f10311w = obj;
        this.f10310v = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x006d, TryCatch #0 {IOException -> 0x006d, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x005b), top: B:30:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static pb.c k(java.lang.String... r12) {
        /*
            int r0 = r12.length     // Catch: java.io.IOException -> L6d
            hf.i[] r0 = new hf.i[r0]     // Catch: java.io.IOException -> L6d
            hf.f r1 = new hf.f     // Catch: java.io.IOException -> L6d
            r1.<init>()     // Catch: java.io.IOException -> L6d
            r2 = 0
            r3 = r2
        La:
            int r4 = r12.length     // Catch: java.io.IOException -> L6d
            if (r3 >= r4) goto L5b
            r4 = r12[r3]     // Catch: java.io.IOException -> L6d
            java.lang.String[] r5 = w5.a.f13738y     // Catch: java.io.IOException -> L6d
            r6 = 34
            r1.j0(r6)     // Catch: java.io.IOException -> L6d
            int r7 = r4.length()     // Catch: java.io.IOException -> L6d
            r8 = r2
            r9 = r8
        L1c:
            if (r8 >= r7) goto L45
            char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L6d
            r11 = 128(0x80, float:1.8E-43)
            if (r10 >= r11) goto L2b
            r10 = r5[r10]     // Catch: java.io.IOException -> L6d
            if (r10 != 0) goto L38
            goto L42
        L2b:
            r11 = 8232(0x2028, float:1.1535E-41)
            if (r10 != r11) goto L32
            java.lang.String r10 = "\\u2028"
            goto L38
        L32:
            r11 = 8233(0x2029, float:1.1537E-41)
            if (r10 != r11) goto L42
            java.lang.String r10 = "\\u2029"
        L38:
            if (r9 >= r8) goto L3d
            r1.n0(r9, r8, r4)     // Catch: java.io.IOException -> L6d
        L3d:
            r1.o0(r10)     // Catch: java.io.IOException -> L6d
            int r9 = r8 + 1
        L42:
            int r8 = r8 + 1
            goto L1c
        L45:
            if (r9 >= r7) goto L4a
            r1.n0(r9, r7, r4)     // Catch: java.io.IOException -> L6d
        L4a:
            r1.j0(r6)     // Catch: java.io.IOException -> L6d
            r1.readByte()     // Catch: java.io.IOException -> L6d
            long r4 = r1.f6113v     // Catch: java.io.IOException -> L6d
            hf.i r4 = r1.m(r4)     // Catch: java.io.IOException -> L6d
            r0[r3] = r4     // Catch: java.io.IOException -> L6d
            int r3 = r3 + 1
            goto La
        L5b:
            pb.c r1 = new pb.c     // Catch: java.io.IOException -> L6d
            java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L6d
            java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L6d
            hf.n r0 = com.bumptech.glide.c.p(r0)     // Catch: java.io.IOException -> L6d
            r2 = 17
            r1.<init>(r12, r2, r0)     // Catch: java.io.IOException -> L6d
            return r1
        L6d:
            r12 = move-exception
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.c.k(java.lang.String[]):pb.c");
    }

    @Override // o8.c
    public void A(o oVar) {
        ((Map) ((p2.c) this.f10311w).f10131w).remove((h) this.f10310v);
    }

    public void a(String str, String str2) {
        be.h.e(str2, "value");
        ((ArrayList) this.f10310v).add(ue.b.b(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 91));
        ((ArrayList) this.f10311w).add(ue.b.b(str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 91));
    }

    public void b(a2.h hVar) {
        synchronized (hVar) {
        }
        Handler handler = (Handler) this.f10310v;
        if (handler != null) {
            handler.post(new i0(this, 14, hVar));
        }
    }

    public View c(int i, int i10, int i11, int i12) {
        e eVar = (e) this.f10311w;
        f1 f1Var = (f1) this.f10310v;
        int iN = f1Var.n();
        int iB = f1Var.b();
        int i13 = i10 > i ? 1 : -1;
        View view = null;
        while (i != i10) {
            View viewK = f1Var.k(i);
            int iG = f1Var.g(viewK);
            int iP = f1Var.p(viewK);
            eVar.f10612b = iN;
            eVar.f10613c = iB;
            eVar.f10614d = iG;
            eVar.f10615e = iP;
            if (i11 != 0) {
                eVar.f10611a = i11;
                if (eVar.a()) {
                    return viewK;
                }
            }
            if (i12 != 0) {
                eVar.f10611a = i12;
                if (eVar.a()) {
                    view = viewK;
                }
            }
            i += i13;
        }
        return view;
    }

    public d d(yb.e eVar) throws xb.c {
        String string;
        JSONArray jSONArray = eVar.f14596g;
        long j5 = eVar.f;
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string2 = jSONObject.getString("rolloutId");
                JSONArray jSONArray2 = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray2.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string2, jSONArray2));
                }
                String strOptString = jSONArray2.optString(0, "");
                yb.e eVarC = ((yb.c) this.f10310v).c();
                String string3 = null;
                if (eVarC == null) {
                    string = null;
                } else {
                    try {
                        string = eVarC.f14592b.getString(strOptString);
                    } catch (JSONException unused) {
                        string = null;
                    }
                }
                if (string == null) {
                    yb.e eVarC2 = ((yb.c) this.f10311w).c();
                    if (eVarC2 != null) {
                        try {
                            string3 = eVarC2.f14592b.getString(strOptString);
                        } catch (JSONException unused2) {
                        }
                    }
                    string = string3 != null ? string3 : "";
                }
                int i10 = bc.e.f2009a;
                bc.b bVar = new bc.b();
                if (string2 == null) {
                    throw new NullPointerException("Null rolloutId");
                }
                bVar.f1999a = string2;
                String string4 = jSONObject.getString("variantId");
                if (string4 == null) {
                    throw new NullPointerException("Null variantId");
                }
                bVar.f2000b = string4;
                if (strOptString == null) {
                    throw new NullPointerException("Null parameterKey");
                }
                bVar.f2001c = strOptString;
                bVar.f2002d = string;
                bVar.f2003e = j5;
                bVar.f = (byte) (bVar.f | 1);
                hashSet.add(bVar.a());
            } catch (JSONException e10) {
                throw new xb.c("Exception parsing rollouts metadata to create RolloutsState.", e10);
            }
        }
        return new d(hashSet);
    }

    public File e() {
        if (((File) this.f10310v) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f10310v) == null) {
                        ga.g gVar = (ga.g) this.f10311w;
                        gVar.a();
                        this.f10310v = new File(gVar.f5346a.getFilesDir(), "PersistedInstallation." + ((ga.g) this.f10311w).d() + ".json");
                    }
                } finally {
                }
            }
        }
        return (File) this.f10310v;
    }

    public w2.o f(Object... objArr) {
        Constructor constructorA;
        synchronized (((AtomicBoolean) this.f10311w)) {
            if (!((AtomicBoolean) this.f10311w).get()) {
                try {
                    constructorA = ((r2.h) this.f10310v).a();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f10311w).set(true);
                    constructorA = null;
                } catch (Exception e10) {
                    throw new RuntimeException("Error instantiating extension", e10);
                }
            }
            constructorA = null;
        }
        if (constructorA == null) {
            return null;
        }
        try {
            return (w2.o) constructorA.newInstance(objArr);
        } catch (Exception e11) {
            throw new IllegalStateException("Unexpected error creating extractor", e11);
        }
    }

    @Override // v1.g
    public v1.h g() {
        return new n((Context) this.f10310v, ((v1.g) this.f10311w).g());
    }

    public String h(String str) {
        String str2 = (String) this.f10311w;
        Resources resources = (Resources) this.f10310v;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public void i(a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", aVar.f10300a);
            jSONObject.put("Status", v.e.c(aVar.f10301b));
            jSONObject.put("AuthToken", aVar.f10302c);
            jSONObject.put("RefreshToken", aVar.f10303d);
            jSONObject.put("TokenCreationEpochInSecs", aVar.f);
            jSONObject.put("ExpiresInSecs", aVar.f10304e);
            jSONObject.put("FisError", aVar.f10305g);
            ga.g gVar = (ga.g) this.f10311w;
            gVar.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", gVar.f5346a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(e())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    public boolean j(View view) {
        e eVar = (e) this.f10311w;
        f1 f1Var = (f1) this.f10310v;
        int iN = f1Var.n();
        int iB = f1Var.b();
        int iG = f1Var.g(view);
        int iP = f1Var.p(view);
        eVar.f10612b = iN;
        eVar.f10613c = iB;
        eVar.f10614d = iG;
        eVar.f10615e = iP;
        eVar.f10611a = 24579;
        return eVar.a();
    }

    public void l(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((s.e) this.f10311w)) {
            ((s.e) this.f10311w).put(new k(cls, cls2, cls3), list);
        }
    }

    public a m() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(e());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } finally {
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int i10 = v.e.d(5)[iOptInt];
        if (i10 == 0) {
            throw new NullPointerException("Null registrationStatus");
        }
        String str = i10 == 0 ? " registrationStatus" : "";
        if (str.isEmpty()) {
            return new a(strOptString, i10, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void n(Object obj) {
        Handler handler = (Handler) this.f10310v;
        if (handler != null) {
            handler.post(new p(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public s1.a o() throws IOException {
        File file = (File) this.f10311w;
        File file2 = (File) this.f10310v;
        if (file2.exists()) {
            if (file.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file)) {
                s1.b.p("AtomicFile", "Couldn't rename file " + file2 + " to backup file " + file);
            }
        }
        try {
            return new s1.a(file2);
        } catch (FileNotFoundException e10) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + file2, e10);
            }
            try {
                return new s1.a(file2);
            } catch (FileNotFoundException e11) {
                throw new IOException("Couldn't create " + file2, e11);
            }
        }
    }

    public void p(r1 r1Var) {
        Handler handler = (Handler) this.f10310v;
        if (handler != null) {
            handler.post(new i0(this, 13, r1Var));
        }
    }

    @Override // o8.g
    public o r(Object obj) {
        Boolean bool = (Boolean) obj;
        m mVar = (m) this.f10311w;
        if (bool.booleanValue()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
            }
            boolean zBooleanValue = bool.booleanValue();
            o2.p pVar = mVar.f12382b;
            if (zBooleanValue) {
                ((h) pVar.f9189z).c(null);
                return ((o) this.f10310v).k(mVar.f12385e.f12823a, new q0.e(10, this));
            }
            pVar.getClass();
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
        }
        Iterator it = za.c.e(((File) mVar.f12386g.f14936c).listFiles(m.f12380r)).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        za.c cVar = ((za.a) mVar.f12391m.f1738c).f14930b;
        za.a.a(za.c.e(((File) cVar.f14938e).listFiles()));
        za.a.a(za.c.e(((File) cVar.f).listFiles()));
        za.a.a(za.c.e(((File) cVar.f14939g).listFiles()));
        mVar.f12395q.c(null);
        return t1.k(null);
    }

    public String toString() {
        switch (this.f10309u) {
            case 1:
                return "Bounds{lower=" + ((i0.d) this.f10310v) + " upper=" + ((i0.d) this.f10311w) + "}";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c(int i, boolean z2) {
        this.f10309u = i;
    }

    public /* synthetic */ c(Object obj, int i, Object obj2) {
        this.f10309u = i;
        this.f10310v = obj;
        this.f10311w = obj2;
    }

    public c(v7.b bVar, c0 c0Var) {
        this.f10309u = 5;
        this.f10311w = "ClientTelemetry.API";
        this.f10310v = bVar;
    }

    public c(int i) {
        this.f10309u = i;
        switch (i) {
            case 12:
                this.f10310v = new AtomicInteger();
                this.f10311w = new AtomicInteger();
                break;
            case 13:
            default:
                this.f10310v = new AtomicReference();
                this.f10311w = new s.e(0);
                break;
            case 14:
                this.f10310v = new ArrayList();
                this.f10311w = new ArrayList();
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(Context context, int i) {
        this(context, new a0.g(6));
        this.f10309u = i;
        switch (i) {
            case 10:
                v.h(context);
                Resources resources = context.getResources();
                this.f10310v = resources;
                this.f10311w = resources.getResourcePackageName(i.common_google_play_services_unknown_issue);
                break;
            case 15:
                break;
            default:
                this.f10310v = context;
                this.f10311w = null;
                break;
        }
    }

    public c(File file) {
        this.f10309u = 6;
        this.f10310v = file;
        this.f10311w = new File(file.getPath() + ".bak");
    }

    public c(nb.b bVar) {
        this.f10309u = 20;
        this.f10311w = Collections.synchronizedMap(new HashMap());
        this.f10310v = bVar;
    }

    public c(ga.g gVar) {
        this.f10309u = 0;
        this.f10311w = gVar;
    }

    public c(Context context, v1.g gVar) {
        this.f10309u = 15;
        this.f10310v = context.getApplicationContext();
        this.f10311w = gVar;
    }

    public c(f1 f1Var) {
        this.f10309u = 2;
        this.f10310v = f1Var;
        e eVar = new e();
        eVar.f10611a = 0;
        this.f10311w = eVar;
    }

    public c(Handler handler, u2.c0 c0Var) {
        this.f10309u = 13;
        if (c0Var != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f10310v = handler;
        this.f10311w = c0Var;
    }

    public c(MediaCodec.CryptoInfo cryptoInfo) {
        this.f10309u = 18;
        this.f10310v = cryptoInfo;
        this.f10311w = j2.e.c();
    }

    public c(WindowInsetsAnimation.Bounds bounds) {
        this.f10309u = 1;
        this.f10310v = i0.d.d(bounds.getLowerBound());
        this.f10311w = i0.d.d(bounds.getUpperBound());
    }

    public c(r2.h hVar) {
        this.f10309u = 16;
        this.f10310v = hVar;
        this.f10311w = new AtomicBoolean(false);
    }
}
