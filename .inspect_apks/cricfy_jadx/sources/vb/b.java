package vb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.api.GoogleScopes;
import d7.s;
import d8.j;
import j9.h;
import j9.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicReference;
import kf.b0;
import kf.e;
import kf.i;
import kf.z;
import nb.f;
import nb.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v1.r1;
import vf.g;
import y2.c0;
import z5.k;
import z6.e0;
import z6.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements h, c5.b, wb.a, k, z7.b, e, com.bumptech.glide.load.data.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13550v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f13551w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f13552x;

    public /* synthetic */ b(int i, Object obj) {
        this.f13550v = i;
        this.f13552x = obj;
    }

    @Override // j9.h
    public p B(Object obj) throws Throwable {
        FileWriter fileWriter;
        j jVar = (j) this.f13552x;
        JSONObject jSONObject = (JSONObject) ((ob.c) this.f13551w).f9744c.f9739v.submit(new g6.k(4, this)).get();
        FileWriter fileWriter2 = null;
        if (jSONObject != null) {
            a aVarJ = ((i) jVar.f3553c).J(jSONObject);
            l4.a aVar = (l4.a) jVar.f3555e;
            long j4 = aVarJ.f13547c;
            aVar.getClass();
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Writing settings to cache file...", null);
            }
            try {
                jSONObject.put("expires_at", j4);
                fileWriter = new FileWriter((File) aVar.f7697v);
                try {
                    try {
                        fileWriter.write(jSONObject.toString());
                        fileWriter.flush();
                    } catch (Throwable th) {
                        th = th;
                        fileWriter2 = fileWriter;
                        f.b(fileWriter2, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                }
            } catch (Exception e10) {
                e = e10;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                f.b(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
            f.b(fileWriter, "Failed to close settings writer.");
            j.f(jSONObject, "Loaded settings: ");
            String str = ((d) jVar.f3552b).f;
            SharedPreferences.Editor editorEdit = ((Context) jVar.f3551a).getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
            editorEdit.putString("existing_instance_identifier", str);
            editorEdit.apply();
            ((AtomicReference) jVar.f3557h).set(aVarJ);
            ((j9.i) ((AtomicReference) jVar.i).get()).c(aVarJ);
        }
        return g.A(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #3 {all -> 0x00a6, blocks: (B:20:0x004c, B:22:0x0050, B:25:0x0061, B:29:0x0068, B:31:0x0075, B:33:0x0080, B:32:0x007b, B:27:0x0065, B:28:0x0067, B:45:0x009e, B:46:0x00a5, B:24:0x005c), top: B:73:0x004c, outer: #5, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[Catch: all -> 0x00a6, TRY_ENTER, TryCatch #3 {all -> 0x00a6, blocks: (B:20:0x004c, B:22:0x0050, B:25:0x0061, B:29:0x0068, B:31:0x0075, B:33:0x0080, B:32:0x007b, B:27:0x0065, B:28:0x0067, B:45:0x009e, B:46:0x00a5, B:24:0x005c), top: B:73:0x004c, outer: #5, inners: #0 }] */
    @Override // c5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c5.a a(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.b.a(java.lang.String):c5.a");
    }

    public void b(g2.f fVar) {
        synchronized (fVar) {
        }
        Handler handler = (Handler) this.f13551w;
        if (handler != null) {
            handler.post(new nc.i(20, this, fVar));
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public void c(Exception exc) {
        e0 e0Var = (e0) this.f13552x;
        s sVar = (s) this.f13551w;
        s sVar2 = e0Var.A;
        if (sVar2 == null || sVar2 != sVar) {
            return;
        }
        e0 e0Var2 = (e0) this.f13552x;
        s sVar3 = (s) this.f13551w;
        z6.k kVar = e0Var2.f15255w;
        z6.d dVar = e0Var2.B;
        com.bumptech.glide.load.data.d dVar2 = sVar3.f3509c;
        kVar.a(dVar, exc, dVar2, dVar2.e());
    }

    @Override // com.bumptech.glide.load.data.c
    public void d(Object obj) {
        e0 e0Var = (e0) this.f13552x;
        s sVar = (s) this.f13551w;
        s sVar2 = e0Var.A;
        if (sVar2 == null || sVar2 != sVar) {
            return;
        }
        e0 e0Var2 = (e0) this.f13552x;
        s sVar3 = (s) this.f13551w;
        m mVar = e0Var2.f15254v.f15272p;
        if (obj != null && mVar.a(sVar3.f3509c.e())) {
            e0Var2.f15258z = obj;
            e0Var2.f15255w.o(2);
        } else {
            z6.k kVar = e0Var2.f15255w;
            x6.e eVar = sVar3.f3507a;
            com.bumptech.glide.load.data.d dVar = sVar3.f3509c;
            kVar.c(eVar, obj, dVar, dVar.e(), e0Var2.B);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory e(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.b.e(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        x5.i iVar = (x5.i) this.f13552x;
        if (iVar.f14352y0.equals((String) this.f13551w)) {
            if (!z10) {
                ((SwipeRefreshLayout) iVar.f14348u0.f2038e).setRefreshing(false);
                ((RecyclerView) iVar.f14348u0.f2037d).setVisibility(8);
                ((TextView) iVar.f14348u0.f2036c).setVisibility(0);
            } else {
                if (iVar.A0.equals("m3u")) {
                    iVar.a0(str);
                    return;
                }
                try {
                    x5.i.V(iVar, new JSONArray(str));
                } catch (JSONException e9) {
                    Log.e("Pro JSONException", e9.getMessage());
                    ((SwipeRefreshLayout) iVar.f14348u0.f2038e).setRefreshing(false);
                    ((RecyclerView) iVar.f14348u0.f2037d).setVisibility(8);
                    ((TextView) iVar.f14348u0.f2036c).setVisibility(0);
                }
            }
        }
    }

    @Override // c5.b
    public boolean g() {
        return ((c5.b) this.f13551w).g();
    }

    @Override // qd.a
    public Object get() {
        return new y7.d((Context) ((u0.d) this.f13551w).f12060v, (l7.a) ((i) this.f13552x).get());
    }

    public void h() throws IOException {
        String str = (String) this.f13551w;
        if (((FileChannel) this.f13552x) != null) {
            return;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f13552x = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = (FileChannel) this.f13552x;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f13552x = null;
            throw new IllegalStateException(l0.e.k("Unable to lock file: '", str, "'."), th);
        }
    }

    public void i(Object obj) {
        Handler handler = (Handler) this.f13551w;
        if (handler != null) {
            handler.post(new o(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    @Override // kf.e
    public void j(IOException iOException) {
        android.support.v4.media.session.b.K((k) this.f13551w, false, iOException.getMessage());
    }

    public y1.a k() throws IOException {
        File file = (File) this.f13552x;
        File file2 = (File) this.f13551w;
        if (file2.exists()) {
            if (file.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file)) {
                y1.b.p("AtomicFile", "Couldn't rename file " + file2 + " to backup file " + file);
            }
        }
        try {
            return new y1.a(file2);
        } catch (FileNotFoundException e9) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + file2, e9);
            }
            try {
                return new y1.a(file2);
            } catch (FileNotFoundException e10) {
                throw new IOException("Couldn't create " + file2, e10);
            }
        }
    }

    public void l(r1 r1Var) {
        Handler handler = (Handler) this.f13551w;
        if (handler != null) {
            handler.post(new nc.i(19, this, r1Var));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Throwable] */
    @Override // kf.e
    public void m(z zVar) {
        Charset charsetA;
        Context context = (Context) this.f13552x;
        k kVar = (k) this.f13551w;
        b0 b0Var = zVar.B;
        if (b0Var == null) {
            android.support.v4.media.session.b.K(kVar, false, "error");
            return;
        }
        ag.g gVarQ = b0Var.q();
        String th = null;
        try {
            kf.s sVarG = b0Var.g();
            if (sVarG == null || (charsetA = kf.s.a(sVarG)) == null) {
                charsetA = ne.a.f9126a;
            }
            String strB0 = gVarQ.b0(lf.f.e(gVarQ, charsetA));
            try {
                gVarQ.close();
            } catch (Throwable th2) {
                th = th2;
            }
            String str = th;
            th = strB0;
            th = str;
        } catch (Throwable th3) {
            th = th3;
            if (gVarQ != null) {
                try {
                    gVarQ.close();
                } catch (Throwable th4) {
                    ab.b.c(th, th4);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
        if (context != null) {
            String str2 = (th.startsWith("{") || th.startsWith("[")) ? th : new String(GoogleScopes.Ninty(context, th));
            if (!TextUtils.isEmpty(str2)) {
                th = str2;
            }
        }
        android.support.v4.media.session.b.K(kVar, zVar.K, th);
        zVar.close();
    }

    @Override // wb.a
    public StackTraceElement[] o(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        wb.a[] aVarArr = (wb.a[]) this.f13551w;
        StackTraceElement[] stackTraceElementArrO = stackTraceElementArr;
        for (int i = 0; i < 1; i++) {
            wb.a aVar = aVarArr[i];
            if (stackTraceElementArrO.length <= 1024) {
                break;
            }
            stackTraceElementArrO = aVar.o(stackTraceElementArr);
        }
        return stackTraceElementArrO.length > 1024 ? ((f9.b0) this.f13552x).o(stackTraceElementArrO) : stackTraceElementArrO;
    }

    public String toString() {
        switch (this.f13550v) {
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                String string = "[ ";
                if (((y.f) this.f13551w) != null) {
                    for (int i = 0; i < 9; i++) {
                        StringBuilder sbB = y.e.b(string);
                        sbB.append(((y.f) this.f13551w).C[i]);
                        sbB.append(" ");
                        string = sbB.toString();
                    }
                }
                return string + "] " + ((y.f) this.f13551w);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f13550v = i;
        this.f13552x = obj;
        this.f13551w = obj2;
    }

    public /* synthetic */ b(int i, Object obj, Object obj2, boolean z10) {
        this.f13550v = i;
        this.f13551w = obj;
        this.f13552x = obj2;
    }

    public b(wb.a[] aVarArr) {
        this.f13550v = 3;
        this.f13551w = aVarArr;
        this.f13552x = new f9.b0(29);
    }

    public b(String str) {
        this.f13550v = 4;
        this.f13551w = str.concat(".lck");
    }

    public b(File file) {
        this.f13550v = 7;
        this.f13551w = file;
        this.f13552x = new File(file.getPath() + ".bak");
    }

    public b(b0.e eVar, c5.b bVar) {
        this.f13550v = 2;
        ge.i.e(bVar, "actual");
        this.f13552x = eVar;
        this.f13551w = bVar;
    }

    public b(Context context) {
        this.f13550v = 10;
        this.f13552x = null;
        this.f13551w = context;
    }

    public b(x5.i iVar) {
        this.f13550v = 5;
        this.f13552x = iVar;
        this.f13551w = iVar.f14352y0;
    }

    public b(Handler handler, c0 c0Var) {
        this.f13550v = 9;
        if (c0Var != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f13551w = handler;
        this.f13552x = c0Var;
    }
}
