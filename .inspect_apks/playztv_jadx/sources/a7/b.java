package a7;

import a0.g;
import aa.m0;
import aa.o0;
import aa.q1;
import android.animation.ValueAnimator;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.location.LocationManager;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.emoji2.text.i;
import androidx.emoji2.text.q;
import androidx.emoji2.text.s;
import androidx.emoji2.text.v;
import androidx.emoji2.text.y;
import androidx.emoji2.text.z;
import androidx.lifecycle.i0;
import androidx.lifecycle.p0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import be.h;
import c2.d0;
import c2.e0;
import c3.e;
import c7.j;
import c7.t;
import cf.l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.navigation.NavigationView;
import d4.b0;
import ea.r;
import f2.f;
import f2.n;
import f2.o;
import f2.x;
import h.k0;
import j2.k;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Adler32;
import n.q3;
import p1.a0;
import p1.g0;
import p1.p;
import s1.u;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t3.d, e7.b, b0, o {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static b f616y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f619w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f620x;

    public /* synthetic */ b(int i, boolean z2) {
        this.f617u = i;
    }

    public static final URL c(b bVar) {
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority((String) bVar.f620x).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp");
        cc.b bVar2 = (cc.b) bVar.f618v;
        Uri.Builder builderAppendPath2 = builderAppendPath.appendPath(bVar2.f2601a).appendPath("settings");
        cc.a aVar = bVar2.f2602b;
        return new URL(builderAppendPath2.appendQueryParameter("build_version", aVar.f2596c).appendQueryParameter("display_version", aVar.f2595b).build().toString());
    }

    public static f p(a0 a0Var) {
        g gVar = new g(6);
        Uri uri = a0Var.f9634b;
        a2.c cVar = new a2.c(uri == null ? null : uri.toString(), a0Var.f, gVar);
        m0 m0Var = a0Var.f9635c;
        o0 o0VarB = m0Var.f710u;
        if (o0VarB == null) {
            o0VarB = m0Var.b();
            m0Var.f710u = o0VarB;
        }
        q1 q1VarJ = o0VarB.iterator();
        while (q1VarJ.hasNext()) {
            Map.Entry entry = (Map.Entry) q1VarJ.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            str.getClass();
            str2.getClass();
            synchronized (((HashMap) cVar.f175x)) {
                ((HashMap) cVar.f175x).put(str, str2);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = p1.g.f9745a;
        k8.a0 a0Var2 = new k8.a0(25);
        UUID uuid2 = a0Var.f9633a;
        b2.f fVar = x.f4753d;
        uuid2.getClass();
        boolean z2 = a0Var.f9636d;
        boolean z10 = a0Var.f9637e;
        int[] iArrS = q1.c.S(a0Var.f9638g);
        for (int i : iArrS) {
            boolean z11 = true;
            if (i != 2 && i != 1) {
                z11 = false;
            }
            s1.d.b(z11);
        }
        f fVar2 = new f(uuid2, fVar, cVar, map, z2, (int[]) iArrS.clone(), z10, a0Var2);
        byte[] bArr = a0Var.f9639h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        s1.d.g(fVar2.F.isEmpty());
        fVar2.O = bArrCopyOf;
        return fVar2;
    }

    public static boolean q(Editable editable, KeyEvent keyEvent, boolean z2) {
        z[] zVarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (zVarArr = (z[]) editable.getSpans(selectionStart, selectionEnd, z.class)) != null && zVarArr.length > 0) {
                for (z zVar : zVarArr) {
                    int spanStart = editable.getSpanStart(zVar);
                    int spanEnd = editable.getSpanEnd(zVar);
                    if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Object A(CharSequence charSequence, int i, int i10, int i11, boolean z2, q qVar) {
        int i12;
        char c9;
        s sVar = new s((v) ((ub.o) this.f619w).f12870x);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i13 = 0;
        boolean zG = true;
        int iCharCount = i;
        loop0: while (true) {
            i12 = iCharCount;
            while (iCharCount < i10 && i13 < i11 && zG) {
                SparseArray sparseArray = sVar.f1195c.f1205a;
                v vVar = sparseArray == null ? null : (v) sparseArray.get(iCodePointAt);
                if (sVar.f1193a == 2) {
                    if (vVar != null) {
                        sVar.f1195c = vVar;
                        sVar.f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            sVar.a();
                        } else if (iCodePointAt != 65039) {
                            v vVar2 = sVar.f1195c;
                            if (vVar2.f1206b != null) {
                                if (sVar.f != 1) {
                                    sVar.f1196d = vVar2;
                                    sVar.a();
                                } else if (sVar.b()) {
                                    sVar.f1196d = sVar.f1195c;
                                    sVar.a();
                                } else {
                                    sVar.a();
                                }
                                c9 = 3;
                            } else {
                                sVar.a();
                            }
                        }
                        c9 = 1;
                    }
                    c9 = 2;
                } else if (vVar == null) {
                    sVar.a();
                    c9 = 1;
                } else {
                    sVar.f1193a = 2;
                    sVar.f1195c = vVar;
                    sVar.f = 1;
                    c9 = 2;
                }
                sVar.f1197e = iCodePointAt;
                if (c9 == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i12)) + i12;
                    if (iCharCount < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c9 == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i10) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c9 == 3) {
                    if (z2 || !w(charSequence, i12, iCharCount, sVar.f1196d.f1206b)) {
                        zG = qVar.g(charSequence, i12, iCharCount, sVar.f1196d.f1206b);
                        i13++;
                    }
                }
            }
            break loop0;
        }
        if (sVar.f1193a == 2 && sVar.f1195c.f1206b != null && ((sVar.f > 1 || sVar.b()) && i13 < i11 && zG && (z2 || !w(charSequence, i12, iCharCount, sVar.f1195c.f1206b)))) {
            qVar.g(charSequence, i12, iCharCount, sVar.f1195c.f1206b);
        }
        return qVar.a();
    }

    public void B(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!((HashSet) this.f618v).remove(mediaCodec) || (loudnessCodecController = (LoudnessCodecController) this.f620x) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void C(j jVar, int i, boolean z2) {
        char c9;
        i7.a aVar = (i7.a) this.f620x;
        Context context = (Context) this.f618v;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = jVar.f2560a;
        String str2 = jVar.f2560a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        z6.d dVar = jVar.f2562c;
        adler32.update(byteBufferAllocate.putInt(m7.a.a(dVar)).array());
        byte[] bArr = jVar.f2561b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z2) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i10 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i10 >= i) {
                        l.l("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", jVar);
                        return;
                    }
                }
            }
        }
        Cursor cursorRawQuery = ((j7.g) ((j7.d) this.f619w)).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(m7.a.a(dVar))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(aVar.a(dVar, jLongValue, i));
            Set set = ((i7.b) aVar.f6445b.get(dVar)).f6448c;
            if (set.contains(i7.c.f6449u)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(i7.c.f6451w)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(i7.c.f6450v)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", m7.a.a(dVar));
            if (bArr != null) {
                c9 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c9 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(aVar.a(dVar, jLongValue, i));
            Integer numValueOf2 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c9] = jVar;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            String strT = l.t("JobInfoScheduler");
            if (Log.isLoggable(strT, 3)) {
                Log.d(strT, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void D(int i) {
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) this.f620x;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f620x = null;
        }
        LoudnessCodecController loudnessCodecControllerCreate = LoudnessCodecController.create(i, r.f4628u, new j2.j(this));
        this.f620x = loudnessCodecControllerCreate;
        Iterator it = ((HashSet) this.f618v).iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    public void E(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f620x = str;
    }

    @Override // t3.d
    public int a(long j5) {
        long[] jArr = (long[]) this.f620x;
        int iA = s1.b0.a(jArr, j5, false);
        if (iA < jArr.length) {
            return iA;
        }
        return -1;
    }

    @Override // f2.o
    public n b(g0 g0Var) {
        f fVar;
        g0Var.f9757b.getClass();
        a0 a0Var = g0Var.f9757b.f9667c;
        if (a0Var == null) {
            return n.f4742j;
        }
        synchronized (this.f618v) {
            try {
                if (!a0Var.equals((a0) this.f619w)) {
                    this.f619w = a0Var;
                    this.f620x = p(a0Var);
                }
                fVar = (f) this.f620x;
                fVar.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object clone() {
        switch (this.f617u) {
            case 9:
                com.google.android.gms.internal.measurement.c cVar = (com.google.android.gms.internal.measurement.c) ((com.google.android.gms.internal.measurement.c) this.f618v).clone();
                int i = 0;
                b bVar = new b(9, (boolean) (0 == true ? 1 : 0));
                bVar.f618v = cVar;
                bVar.f619w = (com.google.android.gms.internal.measurement.c) cVar.clone();
                bVar.f620x = new ArrayList();
                ArrayList arrayList = (ArrayList) this.f620x;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((ArrayList) bVar.f620x).add((com.google.android.gms.internal.measurement.c) ((com.google.android.gms.internal.measurement.c) obj).clone());
                }
                return bVar;
            default:
                return super.clone();
        }
    }

    @Override // d4.b0
    public void d(u uVar) {
        long jD;
        s1.d.h((s1.z) this.f619w);
        int i = s1.b0.f11647a;
        s1.z zVar = (s1.z) this.f619w;
        synchronized (zVar) {
            try {
                long j5 = zVar.f11721c;
                jD = j5 != -9223372036854775807L ? j5 + zVar.f11720b : zVar.d();
            } finally {
            }
        }
        long jE = ((s1.z) this.f619w).e();
        if (jD == -9223372036854775807L || jE == -9223372036854775807L) {
            return;
        }
        p1.q qVar = (p1.q) this.f618v;
        if (jE != qVar.f10028s) {
            p pVarA = qVar.a();
            pVarA.f9972r = jE;
            p1.q qVar2 = new p1.q(pVarA);
            this.f618v = qVar2;
            ((h0) this.f620x).d(qVar2);
        }
        int iA = uVar.a();
        ((h0) this.f620x).f(iA, uVar);
        ((h0) this.f620x).a(jD, 1, iA, 0, null);
    }

    @Override // d4.b0
    public void e(s1.z zVar, w2.q qVar, d4.h0 h0Var) {
        this.f619w = zVar;
        h0Var.a();
        h0Var.b();
        h0 h0VarQ = qVar.q(h0Var.f3888d, 5);
        this.f620x = h0VarQ;
        h0VarQ.d((p1.q) this.f618v);
    }

    @Override // t3.d
    public long f(int i) {
        long[] jArr = (long[]) this.f620x;
        s1.d.b(i >= 0);
        s1.d.b(i < jArr.length);
        return jArr[i];
    }

    public synchronized void g(c6.f fVar, e6.v vVar) {
        e6.b bVar = (e6.b) ((HashMap) this.f618v).put(fVar, new e6.b(fVar, vVar, (ReferenceQueue) this.f619w));
        if (bVar != null) {
            bVar.f4475c = null;
            bVar.clear();
        }
    }

    @Override // md.a
    public Object get() {
        switch (this.f617u) {
            case 8:
                int i = 17;
                return new t(new k8.b0(i), new k8.a0(i), (h7.b) ((zc.c) this.f618v).get(), (b7.s) ((q3) this.f619w).get(), (ub.o) ((ub.o) this.f620x).get());
            default:
                return new b((Context) ((md.a) this.f618v).get(), (j7.d) ((md.a) this.f619w).get(), (i7.a) ((t7.j) this.f620x).get(), 24);
        }
    }

    public void h(int[] iArr, ValueAnimator valueAnimator) {
        pa.b bVar = new pa.b(iArr, 15, valueAnimator);
        valueAnimator.addListener((g5.l) this.f620x);
        ((ArrayList) this.f618v).add(bVar);
    }

    @Override // t3.d
    public List i(long j5) {
        List list = (List) this.f618v;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            long[] jArr = (long[]) this.f619w;
            int i10 = i * 2;
            if (jArr[i10] <= j5 && j5 < jArr[i10 + 1]) {
                c4.c cVar = (c4.c) list.get(i);
                r1.b bVar = cVar.f2478a;
                if (bVar.f11257e == -3.4028235E38f) {
                    arrayList2.add(cVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new c4.d(1));
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            r1.a aVarA = ((c4.c) arrayList2.get(i11)).f2478a.a();
            aVarA.f11233e = (-1) - i11;
            aVarA.f = 1;
            arrayList.add(aVarA.a());
        }
        return arrayList;
    }

    @Override // t3.d
    public int j() {
        return ((long[]) this.f620x).length;
    }

    public j k() {
        String strConcat = ((String) this.f620x) == null ? " backendName" : "";
        if (((z6.d) this.f619w) == null) {
            strConcat = strConcat.concat(" priority");
        }
        if (strConcat.isEmpty()) {
            return new j((String) this.f620x, (byte[]) this.f618v, (z6.d) this.f619w);
        }
        throw new IllegalStateException("Missing required properties:".concat(strConcat));
    }

    public String l(String str, long j5, int i, long j8) {
        ArrayList arrayList = (ArrayList) this.f618v;
        ArrayList arrayList2 = (ArrayList) this.f620x;
        ArrayList arrayList3 = (ArrayList) this.f619w;
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < arrayList3.size(); i10++) {
            sb2.append((String) arrayList.get(i10));
            if (((Integer) arrayList3.get(i10)).intValue() == 1) {
                sb2.append(str);
            } else if (((Integer) arrayList3.get(i10)).intValue() == 2) {
                sb2.append(String.format(Locale.US, (String) arrayList2.get(i10), Long.valueOf(j5)));
            } else if (((Integer) arrayList3.get(i10)).intValue() == 3) {
                sb2.append(String.format(Locale.US, (String) arrayList2.get(i10), Integer.valueOf(i)));
            } else if (((Integer) arrayList3.get(i10)).intValue() == 4) {
                sb2.append(String.format(Locale.US, (String) arrayList2.get(i10), Long.valueOf(j8)));
            }
        }
        sb2.append((String) arrayList.get(arrayList3.size()));
        return sb2.toString();
    }

    public void m() {
        synchronized (this.f619w) {
            Iterator it = ((LinkedHashMap) this.f620x).entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() == null) {
                    it.remove();
                }
            }
        }
    }

    public void n(e6.b bVar) {
        e6.b0 b0Var;
        synchronized (this) {
            ((HashMap) this.f618v).remove(bVar.f4473a);
            if (bVar.f4474b && (b0Var = bVar.f4475c) != null) {
                ((e6.n) this.f620x).f(bVar.f4473a, new e6.v(b0Var, true, false, bVar.f4473a, (e6.n) this.f620x));
            }
        }
    }

    public void o() {
        synchronized (this.f619w) {
            ((LinkedHashMap) this.f620x).clear();
        }
    }

    public void r(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.f618v;
        jb.f fVar = new jb.f(byteArrayOutputStream, map, (HashMap) this.f619w, (gb.d) this.f620x);
        gb.d dVar = (gb.d) map.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
        } else {
            throw new gb.b("No encoder for " + obj.getClass());
        }
    }

    public androidx.lifecycle.o0 s(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return t(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public androidx.lifecycle.o0 t(Class cls, String str) {
        androidx.lifecycle.o0 o0VarA;
        r0 r0Var = (r0) this.f619w;
        h.e(str, "key");
        t0 t0Var = (t0) this.f618v;
        t0Var.getClass();
        LinkedHashMap linkedHashMap = t0Var.f1501a;
        androidx.lifecycle.o0 o0Var = (androidx.lifecycle.o0) linkedHashMap.get(str);
        if (!cls.isInstance(o0Var)) {
            n1.c cVar = new n1.c((e) this.f620x);
            ((LinkedHashMap) cVar.f2454v).put(p0.f1495b, str);
            try {
                o0VarA = r0Var.b(cls, cVar);
            } catch (AbstractMethodError unused) {
                o0VarA = r0Var.a(cls);
            }
            h.e(o0VarA, "viewModel");
            androidx.lifecycle.o0 o0Var2 = (androidx.lifecycle.o0) linkedHashMap.put(str, o0VarA);
            if (o0Var2 != null) {
                o0Var2.b();
            }
            return o0VarA;
        }
        androidx.lifecycle.m0 m0Var = r0Var instanceof androidx.lifecycle.m0 ? (androidx.lifecycle.m0) r0Var : null;
        if (m0Var != null) {
            h.b(o0Var);
            androidx.lifecycle.u uVar = m0Var.f1480d;
            if (uVar != null) {
                n.s sVar = m0Var.f1481e;
                h.b(sVar);
                i0.a(o0Var, sVar, uVar);
            }
        }
        h.c(o0Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return o0Var;
    }

    public fd.a u(int i, id.o oVar) {
        fd.a aVar;
        h.e(oVar, "reason");
        synchronized (this.f619w) {
            try {
                WeakReference weakReference = (WeakReference) ((LinkedHashMap) this.f620x).get(Integer.valueOf(i));
                aVar = weakReference != null ? (fd.a) weakReference.get() : null;
                if (aVar == null) {
                    aVar = new fd.a();
                    aVar.a(((ed.a) this.f618v).f4676a.d(i), null, oVar);
                    ((LinkedHashMap) this.f620x).put(Integer.valueOf(i), new WeakReference(aVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void v(int i, zc.e eVar, id.o oVar) {
        h.e(eVar, "download");
        h.e(oVar, "reason");
        synchronized (this.f619w) {
            u(i, oVar).a(((ed.a) this.f618v).a(i, eVar), eVar, oVar);
        }
    }

    public boolean w(CharSequence charSequence, int i, int i10, y yVar) {
        if ((yVar.f1214c & 3) == 0) {
            i iVar = (i) this.f620x;
            f1.a aVarB = yVar.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarB.f4694x).getShort(iA + aVarB.f4691u);
            }
            androidx.emoji2.text.e eVar = (androidx.emoji2.text.e) iVar;
            eVar.getClass();
            ThreadLocal threadLocal = androidx.emoji2.text.e.f1168b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = (StringBuilder) threadLocal.get();
            sb2.setLength(0);
            while (i < i10) {
                sb2.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = eVar.f1169a;
            String string = sb2.toString();
            int i11 = i0.e.f6165a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i12 = yVar.f1214c & 4;
            yVar.f1214c = zHasGlyph ? i12 | 2 : i12 | 1;
        }
        return (yVar.f1214c & 3) == 2;
    }

    public boolean x() throws IOException {
        String strTrim;
        ArrayDeque arrayDeque = (ArrayDeque) this.f619w;
        if (((String) this.f620x) == null) {
            if (!arrayDeque.isEmpty()) {
                String str = (String) arrayDeque.poll();
                str.getClass();
                this.f620x = str;
                return true;
            }
            do {
                String line = ((BufferedReader) this.f618v).readLine();
                this.f620x = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f620x = strTrim;
            } while (strTrim.isEmpty());
        }
        return true;
    }

    public String y() {
        if (!x()) {
            throw new NoSuchElementException();
        }
        String str = (String) this.f620x;
        this.f620x = null;
        return str;
    }

    public void z(int i, zc.e eVar, id.o oVar) {
        h.e(eVar, "download");
        h.e(oVar, "reason");
        synchronized (this.f619w) {
            try {
                WeakReference weakReference = (WeakReference) ((LinkedHashMap) this.f620x).get(Integer.valueOf(i));
                fd.a aVar = weakReference != null ? (fd.a) weakReference.get() : null;
                if (aVar != null) {
                    aVar.a(((ed.a) this.f618v).a(i, eVar), eVar, oVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f617u = i;
        this.f618v = obj;
        this.f619w = obj2;
        this.f620x = obj3;
    }

    public b(String str, String str2, byte[] bArr) {
        this.f617u = 28;
        this.f618v = bArr;
        this.f620x = str;
        this.f619w = str2;
    }

    public b(ed.a aVar) {
        this.f617u = 20;
        this.f618v = aVar;
        this.f619w = new Object();
        this.f620x = new LinkedHashMap();
    }

    public b(int i) {
        this.f617u = i;
        switch (i) {
            case 18:
                this.f618v = new Object();
                break;
            case 25:
                k kVar = k.f6707u;
                this.f618v = new HashSet();
                this.f619w = kVar;
                break;
            case 26:
                this.f618v = new ArrayList();
                this.f619w = null;
                this.f620x = new g5.l(3, this);
                break;
            default:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new e6.a(0));
                this.f618v = new HashMap();
                this.f619w = new ReferenceQueue();
                executorServiceNewSingleThreadExecutor.execute(new androidx.fragment.app.e(5, this));
                break;
        }
    }

    public b(ArrayList arrayList) {
        this.f617u = 6;
        this.f618v = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f619w = new long[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            c4.c cVar = (c4.c) arrayList.get(i);
            int i10 = i * 2;
            long[] jArr = (long[]) this.f619w;
            jArr[i10] = cVar.f2479b;
            jArr[i10 + 1] = cVar.f2480c;
        }
        long[] jArr2 = (long[]) this.f619w;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f620x = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public b(cc.b bVar, rd.h hVar) {
        this.f617u = 17;
        this.f618v = bVar;
        this.f619w = hVar;
        this.f620x = "firebase-settings.crashlytics.com";
    }

    public b(t0 t0Var, r0 r0Var, e eVar) {
        this.f617u = 2;
        h.e(t0Var, "store");
        h.e(r0Var, "factory");
        h.e(eVar, "defaultCreationExtras");
        this.f618v = t0Var;
        this.f619w = r0Var;
        this.f620x = eVar;
    }

    public b(String str) {
        this.f617u = 10;
        p pVar = new p();
        pVar.f9966l = p1.m0.p("video/mp2t");
        pVar.f9967m = p1.m0.p(str);
        this.f618v = new p1.q(pVar);
    }

    public b(NavigationView navigationView) {
        Object cVar;
        this.f617u = 29;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            cVar = new k9.e();
        } else {
            cVar = i >= 33 ? new k9.c() : null;
        }
        this.f618v = cVar;
        this.f619w = navigationView;
        this.f620x = navigationView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(t0 t0Var, r0 r0Var) {
        this(t0Var, r0Var, n1.a.f8635w);
        this.f617u = 2;
        h.e(t0Var, "store");
    }

    public b(Context context, LocationManager locationManager) {
        this.f617u = 21;
        this.f620x = new k0();
        this.f618v = context;
        this.f619w = locationManager;
    }

    public b(byte[] bArr, ea.y yVar) {
        this.f617u = 19;
        this.f618v = bArr;
        this.f619w = null;
        this.f620x = yVar;
    }

    public b(Uri uri, ea.y yVar) {
        this.f617u = 19;
        this.f618v = null;
        this.f619w = uri;
        this.f620x = yVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(u0 u0Var) {
        r0 r0VarC;
        e eVarD;
        this.f617u = 2;
        h.e(u0Var, "owner");
        t0 t0VarE = u0Var.e();
        boolean z2 = u0Var instanceof androidx.lifecycle.i;
        if (z2) {
            r0VarC = ((androidx.lifecycle.i) u0Var).c();
        } else {
            if (s0.f1498a == null) {
                s0.f1498a = new s0();
            }
            r0VarC = s0.f1498a;
            h.b(r0VarC);
        }
        if (z2) {
            eVarD = ((androidx.lifecycle.i) u0Var).d();
        } else {
            eVarD = n1.a.f8635w;
        }
        this(t0VarE, r0VarC, eVarD);
    }

    public b(ub.o oVar, t7.j jVar, androidx.emoji2.text.e eVar, Set set) {
        this.f617u = 1;
        this.f618v = jVar;
        this.f619w = oVar;
        this.f620x = eVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            A(str, 0, str.length(), 1, true, new androidx.emoji2.text.r(str, false));
        }
    }

    public b(q1.g[] gVarArr) {
        this.f617u = 3;
        c2.i0 i0Var = new c2.i0();
        q1.j jVar = new q1.j();
        jVar.f10576c = 1.0f;
        jVar.f10577d = 1.0f;
        q1.e eVar = q1.e.f10542e;
        jVar.f10578e = eVar;
        jVar.f = eVar;
        jVar.f10579g = eVar;
        jVar.f10580h = eVar;
        ByteBuffer byteBuffer = q1.g.f10547a;
        jVar.f10582k = byteBuffer;
        jVar.f10583l = byteBuffer.asShortBuffer();
        jVar.f10584m = byteBuffer;
        jVar.f10575b = -1;
        q1.g[] gVarArr2 = new q1.g[gVarArr.length + 2];
        this.f618v = gVarArr2;
        System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
        this.f619w = i0Var;
        this.f620x = jVar;
        gVarArr2[gVarArr.length] = i0Var;
        gVarArr2[gVarArr.length + 1] = jVar;
    }

    public b(e6.n nVar, t6.h hVar, e6.r rVar) {
        this.f617u = 16;
        this.f620x = nVar;
        this.f619w = hVar;
        this.f618v = rVar;
    }

    public b(ArrayDeque arrayDeque, BufferedReader bufferedReader) {
        this.f617u = 22;
        this.f619w = arrayDeque;
        this.f618v = bufferedReader;
    }

    public b(AudioTrack audioTrack, c2.f fVar) {
        this.f617u = 4;
        this.f618v = audioTrack;
        this.f619w = fVar;
        this.f620x = new AudioRouting.OnRoutingChangedListener() { // from class: c2.a0
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                AudioDeviceInfo routedDevice;
                a7.b bVar = this.f2242a;
                if (((a0) bVar.f620x) == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
                    return;
                }
                ((f) bVar.f619w).b(routedDevice);
            }
        };
        audioTrack.addOnRoutingChangedListener((c2.a0) this.f620x, new Handler(Looper.myLooper()));
    }

    public b(e0 e0Var) {
        this.f617u = 5;
        this.f620x = e0Var;
        this.f618v = new Handler(Looper.myLooper());
        this.f619w = new d0(this);
    }
}
