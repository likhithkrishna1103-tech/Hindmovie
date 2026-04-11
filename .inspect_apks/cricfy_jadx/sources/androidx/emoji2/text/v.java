package androidx.emoji2.text;

import a3.i0;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.navigation.NavigationView;
import f9.q4;
import f9.r1;
import f9.s0;
import f9.y0;
import f9.z2;
import h.j0;
import h4.g0;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.Adler32;
import k4.r0;
import ua.k0;
import ua.m0;
import ua.n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements z7.b, b2.g, z2, y0, x3.g, h4.b0, j9.d, l2.o {
    public static v A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static v f886z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f890y;

    public /* synthetic */ v(q4 q4Var, String str, Object obj, int i) {
        this.f887v = i;
        this.f888w = str;
        this.f889x = obj;
        this.f890y = q4Var;
    }

    public static l2.f n(v1.z zVar) {
        b2.q qVar = new b2.q(0);
        Uri uri = zVar.f13056b;
        com.bumptech.glide.l lVar = new com.bumptech.glide.l(uri == null ? null : uri.toString(), zVar.f, qVar);
        k0 k0Var = zVar.f13057c;
        m0 m0VarB = k0Var.f12349v;
        if (m0VarB == null) {
            m0VarB = k0Var.b();
            k0Var.f12349v = m0VarB;
        }
        n1 it = m0VarB.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            str.getClass();
            str2.getClass();
            synchronized (((HashMap) lVar.f2225y)) {
                ((HashMap) lVar.f2225y).put(str, str2);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = v1.f.f12657a;
        f9.a0 a0Var = new f9.a0(28);
        UUID uuid2 = zVar.f13055a;
        r0 r0Var = l2.x.f7686d;
        uuid2.getClass();
        boolean z10 = zVar.f13058d;
        boolean z11 = zVar.f13059e;
        int[] iArrC = com.bumptech.glide.d.C(zVar.f13060g);
        for (int i : iArrC) {
            boolean z12 = true;
            if (i != 2 && i != 1) {
                z12 = false;
            }
            y1.d.b(z12);
        }
        l2.f fVar = new l2.f(uuid2, r0Var, lVar, map, z10, (int[]) iArrC.clone(), z11, a0Var);
        byte[] bArr = zVar.f13061h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        y1.d.g(fVar.G.isEmpty());
        fVar.P = bArrCopyOf;
        return fVar;
    }

    public static boolean p(Editable editable, KeyEvent keyEvent, boolean z10) {
        d0[] d0VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (d0VarArr = (d0[]) editable.getSpans(selectionStart, selectionEnd, d0.class)) != null && d0VarArr.length > 0) {
                for (d0 d0Var : d0VarArr) {
                    int spanStart = editable.getSpanStart(d0Var);
                    int spanEnd = editable.getSpanEnd(d0Var);
                    if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // j9.d
    public void A(j9.p pVar) {
        k8.b bVar = (k8.b) this.f888w;
        String str = (String) this.f889x;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f890y;
        synchronized (bVar.f7247a) {
            bVar.f7247a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    public Object B(CharSequence charSequence, int i, int i10, int i11, boolean z10, s sVar) {
        int i12;
        char c9;
        u uVar = new u((z) ((b6.f) this.f889x).f1802y);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i13 = 0;
        boolean zF = true;
        int iCharCount = i;
        loop0: while (true) {
            i12 = iCharCount;
            while (iCharCount < i10 && i13 < i11 && zF) {
                SparseArray sparseArray = uVar.f883c.f901a;
                z zVar = sparseArray == null ? null : (z) sparseArray.get(iCodePointAt);
                if (uVar.f881a == 2) {
                    if (zVar != null) {
                        uVar.f883c = zVar;
                        uVar.f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            uVar.a();
                        } else if (iCodePointAt != 65039) {
                            z zVar2 = uVar.f883c;
                            if (zVar2.f902b != null) {
                                if (uVar.f != 1) {
                                    uVar.f884d = zVar2;
                                    uVar.a();
                                } else if (uVar.b()) {
                                    uVar.f884d = uVar.f883c;
                                    uVar.a();
                                } else {
                                    uVar.a();
                                }
                                c9 = 3;
                            } else {
                                uVar.a();
                            }
                        }
                        c9 = 1;
                    }
                    c9 = 2;
                } else if (zVar == null) {
                    uVar.a();
                    c9 = 1;
                } else {
                    uVar.f881a = 2;
                    uVar.f883c = zVar;
                    uVar.f = 1;
                    c9 = 2;
                }
                uVar.f885e = iCodePointAt;
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
                    if (z10 || !w(charSequence, i12, iCharCount, uVar.f884d.f902b)) {
                        zF = sVar.f(charSequence, i12, iCharCount, uVar.f884d.f902b);
                        i13++;
                    }
                }
            }
            break loop0;
        }
        if (uVar.f881a == 2 && uVar.f883c.f902b != null && ((uVar.f > 1 || uVar.b()) && i13 < i11 && zF && (z10 || !w(charSequence, i12, iCharCount, uVar.f883c.f902b)))) {
            sVar.f(charSequence, i12, iCharCount, uVar.f883c.f902b);
        }
        return sVar.d();
    }

    public void C(x7.i iVar, int i, boolean z10) {
        char c9;
        d8.b bVar = (d8.b) this.f890y;
        Context context = (Context) this.f888w;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = iVar.f14434a;
        String str2 = iVar.f14434a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        u7.d dVar = iVar.f14436c;
        adler32.update(byteBufferAllocate.putInt(h8.a.a(dVar)).array());
        byte[] bArr = iVar.f14435b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z10) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i10 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i10 >= i) {
                        vf.g.t("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
                        return;
                    }
                }
            }
        }
        Cursor cursorRawQuery = ((e8.i) ((e8.d) this.f889x)).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(h8.a.a(dVar))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(bVar.a(dVar, jLongValue, i));
            Set set = ((d8.c) bVar.f3524b.get(dVar)).f3527c;
            if (set.contains(d8.d.f3528v)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(d8.d.f3530x)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(d8.d.f3529w)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", h8.a.a(dVar));
            if (bArr != null) {
                c9 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c9 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(bVar.a(dVar, jLongValue, i));
            Integer numValueOf2 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c9] = iVar;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            String strG = vf.g.G("JobInfoScheduler");
            if (Log.isLoggable(strG, 3)) {
                Log.d(strG, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void D(Map map) {
        l4.c0 c0Var = (l4.c0) this.f888w;
        synchronized (c0Var) {
            c0Var.f7706x = null;
            ((HashMap) c0Var.f7705w).clear();
            ((HashMap) c0Var.f7705w).putAll(map);
        }
    }

    public void E(a0.e eVar, int i, int i10, int i11) {
        eVar.getClass();
        int i12 = eVar.f29b0;
        int i13 = eVar.f31c0;
        eVar.f29b0 = 0;
        eVar.f31c0 = 0;
        eVar.O(i10);
        eVar.L(i11);
        if (i12 < 0) {
            eVar.f29b0 = 0;
        } else {
            eVar.f29b0 = i12;
        }
        if (i13 < 0) {
            eVar.f31c0 = 0;
        } else {
            eVar.f31c0 = i13;
        }
        a0.e eVar2 = (a0.e) this.f890y;
        eVar2.f68t0 = i;
        eVar2.U();
    }

    public void H(a0.e eVar) {
        ArrayList arrayList = (ArrayList) this.f888w;
        arrayList.clear();
        int size = eVar.f65q0.size();
        for (int i = 0; i < size; i++) {
            a0.d dVar = (a0.d) eVar.f65q0.get(i);
            int[] iArr = dVar.f54p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(dVar);
            }
        }
        eVar.f67s0.f1595a = true;
    }

    public synchronized void I(int i, int i10, long j4, long j7) {
        ((r1) this.f888w).F.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = (AtomicLong) this.f890y;
        if (atomicLong.get() != -1 && jElapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        j9.p pVarA = ((q8.c) this.f889x).a(new o8.l(0, Arrays.asList(new o8.i(36301, i, 0, j4, j7, null, null, 0, i10))));
        s0 s0Var = new s0(this, jElapsedRealtime, 0);
        pVarA.getClass();
        pVarA.c(j9.j.f6689a, s0Var);
    }

    @Override // x3.g
    public int a(long j4) {
        long[] jArr = (long[]) this.f890y;
        int iA = y1.a0.a(jArr, j4, false);
        if (iA < jArr.length) {
            return iA;
        }
        return -1;
    }

    @Override // h4.b0
    public void b(y1.t tVar) {
        long jD;
        y1.d.h((y1.y) this.f889x);
        int i = y1.a0.f14551a;
        y1.y yVar = (y1.y) this.f889x;
        synchronized (yVar) {
            try {
                long j4 = yVar.f14621c;
                jD = j4 != -9223372036854775807L ? j4 + yVar.f14620b : yVar.d();
            } finally {
            }
        }
        long jE = ((y1.y) this.f889x).e();
        if (jD == -9223372036854775807L || jE == -9223372036854775807L) {
            return;
        }
        v1.p pVar = (v1.p) this.f888w;
        if (jE != pVar.f12951s) {
            v1.o oVarA = pVar.a();
            oVarA.f12898r = jE;
            v1.p pVar2 = new v1.p(oVarA);
            this.f888w = pVar2;
            ((i0) this.f890y).f(pVar2);
        }
        int iA = tVar.a();
        ((i0) this.f890y).a(iA, tVar);
        ((i0) this.f890y).e(jD, 1, iA, 0, null);
    }

    @Override // h4.b0
    public void c(y1.y yVar, a3.r rVar, g0 g0Var) {
        this.f889x = yVar;
        g0Var.a();
        g0Var.b();
        i0 i0VarP = rVar.p(g0Var.f5645d, 5);
        this.f890y = i0VarP;
        i0VarP.f((v1.p) this.f888w);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        switch (this.f887v) {
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                v vVar = new v(((com.google.android.gms.internal.measurement.b) this.f888w).clone());
                ArrayList arrayList = (ArrayList) this.f890y;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((ArrayList) vVar.f890y).add(((com.google.android.gms.internal.measurement.b) obj).clone());
                }
                return vVar;
            default:
                return super.clone();
        }
    }

    @Override // l2.o
    public l2.n d(v1.g0 g0Var) {
        l2.f fVar;
        g0Var.f12697b.getClass();
        v1.z zVar = g0Var.f12697b.f12607c;
        if (zVar == null) {
            return l2.n.f7675k;
        }
        synchronized (this.f888w) {
            try {
                if (!zVar.equals((v1.z) this.f889x)) {
                    this.f889x = zVar;
                    this.f890y = n(zVar);
                }
                fVar = (l2.f) this.f890y;
                fVar.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // x3.g
    public long e(int i) {
        long[] jArr = (long[]) this.f890y;
        y1.d.b(i >= 0);
        y1.d.b(i < jArr.length);
        return jArr[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    @Override // f9.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(int r12, java.lang.Throwable r13, byte[] r14) {
        /*
            r11 = this;
            java.lang.Object r14 = r11.f888w
            f9.x2 r14 = (f9.x2) r14
            r14.m1()
            java.lang.Object r0 = r11.f890y
            f9.i4 r0 = (f9.i4) r0
            r1 = 200(0xc8, float:2.8E-43)
            if (r12 == r1) goto L18
            r1 = 204(0xcc, float:2.86E-43)
            if (r12 == r1) goto L18
            r1 = 304(0x130, float:4.26E-43)
            if (r12 != r1) goto L33
            r12 = r1
        L18:
            if (r13 != 0) goto L33
            java.lang.Object r12 = r14.f307w
            f9.r1 r12 = (f9.r1) r12
            f9.w0 r12 = r12.A
            f9.r1.g(r12)
            f9.u0 r12 = r12.J
            long r1 = r0.f4222v
            java.lang.Long r13 = java.lang.Long.valueOf(r1)
            java.lang.String r1 = "[sgtm] Upload succeeded for row_id"
            r12.b(r13, r1)
            f9.d3 r12 = f9.d3.f4076x
            goto L6f
        L33:
            java.lang.Object r1 = r14.f307w
            f9.r1 r1 = (f9.r1) r1
            f9.w0 r1 = r1.A
            f9.r1.g(r1)
            f9.u0 r1 = r1.E
            long r2 = r0.f4222v
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            java.lang.String r4 = "[sgtm] Upload failed for row_id. response, exception"
            r1.d(r4, r2, r3, r13)
            f9.e0 r13 = f9.f0.f4156u
            r1 = 0
            java.lang.Object r13 = r13.a(r1)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r1 = ","
            java.lang.String[] r13 = r13.split(r1)
            java.util.List r13 = java.util.Arrays.asList(r13)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            boolean r12 = r13.contains(r12)
            if (r12 == 0) goto L6d
            f9.d3 r12 = f9.d3.f4078z
            goto L6f
        L6d:
            f9.d3 r12 = f9.d3.f4077y
        L6f:
            java.lang.Object r13 = r11.f889x
            java.util.concurrent.atomic.AtomicReference r13 = (java.util.concurrent.atomic.AtomicReference) r13
            java.lang.Object r1 = r14.f307w
            f9.r1 r1 = (f9.r1) r1
            f9.t3 r4 = r1.j()
            f9.d r5 = new f9.d
            long r7 = r0.f4222v
            int r6 = r12.f4079v
            long r9 = r0.A
            r5.<init>(r6, r7, r9)
            r0 = r7
            r4.m1()
            r4.n1()
            r2 = 1
            f9.w4 r2 = r4.C1(r2)
            r6 = r5
            r5 = r2
            f9.v1 r2 = new f9.v1
            r3 = 7
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7)
            r4.A1(r2)
            java.lang.Object r14 = r14.f307w
            f9.r1 r14 = (f9.r1) r14
            f9.w0 r14 = r14.A
            f9.r1.g(r14)
            f9.u0 r14 = r14.J
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "[sgtm] Updated status for row_id"
            r14.c(r0, r12, r1)
            monitor-enter(r13)
            r13.set(r12)     // Catch: java.lang.Throwable -> Lbb
            r13.notifyAll()     // Catch: java.lang.Throwable -> Lbb
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lbb
            return
        Lbb:
            r0 = move-exception
            r12 = r0
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lbb
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.v.f(int, java.lang.Throwable, byte[]):void");
    }

    public String g(String str, long j4, int i, long j7) {
        ArrayList arrayList = (ArrayList) this.f888w;
        ArrayList arrayList2 = (ArrayList) this.f890y;
        ArrayList arrayList3 = (ArrayList) this.f889x;
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < arrayList3.size(); i10++) {
            sb.append((String) arrayList.get(i10));
            if (((Integer) arrayList3.get(i10)).intValue() == 1) {
                sb.append(str);
            } else if (((Integer) arrayList3.get(i10)).intValue() == 2) {
                sb.append(String.format(Locale.US, (String) arrayList2.get(i10), Long.valueOf(j4)));
            } else if (((Integer) arrayList3.get(i10)).intValue() == 3) {
                sb.append(String.format(Locale.US, (String) arrayList2.get(i10), Integer.valueOf(i)));
            } else if (((Integer) arrayList3.get(i10)).intValue() == 4) {
                sb.append(String.format(Locale.US, (String) arrayList2.get(i10), Long.valueOf(j7)));
            }
        }
        sb.append((String) arrayList.get(arrayList3.size()));
        return sb.toString();
    }

    @Override // qd.a
    public Object get() {
        return new v((Context) ((qd.a) this.f888w).get(), (e8.d) ((qd.a) this.f889x).get(), (d8.b) ((o8.j) this.f890y).get(), 7);
    }

    @Override // b2.g
    public b2.h h() {
        return new d2.a((kf.u) this.f889x, (String) this.f890y, (l4.c0) this.f888w);
    }

    @Override // x3.g
    public List i(long j4) {
        List list = (List) this.f888w;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            long[] jArr = (long[]) this.f889x;
            int i10 = i * 2;
            if (jArr[i10] <= j4 && j4 < jArr[i10 + 1]) {
                g4.c cVar = (g4.c) list.get(i);
                x1.b bVar = cVar.f4998a;
                if (bVar.f14253e == -3.4028235E38f) {
                    arrayList2.add(cVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new g4.d(1));
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            x1.a aVarA = ((g4.c) arrayList2.get(i11)).f4998a.a();
            aVarA.f14229e = (-1) - i11;
            aVarA.f = 1;
            arrayList.add(aVarA.a());
        }
        return arrayList;
    }

    @Override // x3.g
    public int j() {
        return ((long[]) this.f890y).length;
    }

    public void k() {
        synchronized (this.f889x) {
            Iterator it = ((LinkedHashMap) this.f890y).entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() == null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:6:0x0020, B:21:0x006b, B:24:0x008f, B:15:0x0032, B:17:0x0058, B:19:0x0063, B:20:0x0067), top: B:31:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:6:0x0020, B:21:0x006b, B:24:0x008f, B:15:0x0032, B:17:0x0058, B:19:0x0063, B:20:0x0067), top: B:31:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
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
    @Override // f9.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.v.l(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public void m() {
        synchronized (this.f889x) {
            ((LinkedHashMap) this.f890y).clear();
        }
    }

    public Bitmap o(BitmapFactory.Options options) throws Throwable {
        switch (this.f887v) {
            case 16:
                return g7.r.c(new s7.a(s7.b.c((ByteBuffer) this.f888w)), options, this);
            case 17:
                g7.x xVar = (g7.x) ((com.bumptech.glide.load.data.h) this.f888w).f2236w;
                xVar.reset();
                return g7.r.c(xVar, options, this);
            default:
                FileDescriptor fileDescriptor = ((com.bumptech.glide.load.data.h) this.f890y).e().getFileDescriptor();
                Bitmap bitmapE = null;
                if (Build.VERSION.SDK_INT != 34 || !g7.r.a(options) || !g7.r.d(this)) {
                    return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                }
                s7.f.a("", options.inPreferredConfig == Bitmap.Config.HARDWARE);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    Bitmap bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (bitmapDecodeFileDescriptor == null) {
                        if (bitmapDecodeFileDescriptor != null) {
                        }
                        options.inPreferredConfig = Bitmap.Config.HARDWARE;
                        return bitmapE;
                    }
                    try {
                        bitmapE = g7.r.e(bitmapDecodeFileDescriptor);
                    } catch (Throwable th) {
                        th = th;
                        bitmapE = bitmapDecodeFileDescriptor;
                        if (bitmapE != null) {
                            bitmapE.recycle();
                        }
                        options.inPreferredConfig = Bitmap.Config.HARDWARE;
                        throw th;
                    }
                    break;
                    bitmapDecodeFileDescriptor.recycle();
                    options.inPreferredConfig = Bitmap.Config.HARDWARE;
                    return bitmapE;
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
        }
    }

    public void q(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.f888w;
        dc.f fVar = new dc.f(byteArrayOutputStream, map, (HashMap) this.f889x, (ac.d) this.f890y);
        ac.d dVar = (ac.d) map.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
        } else {
            throw new ac.b("No encoder for " + obj.getClass());
        }
    }

    public o0 r(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return s(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public o0 s(Class cls, String str) {
        o0 o0VarA;
        androidx.lifecycle.r0 r0Var = (androidx.lifecycle.r0) this.f889x;
        ge.i.e(str, "key");
        t0 t0Var = (t0) this.f888w;
        t0Var.getClass();
        LinkedHashMap linkedHashMap = t0Var.f1197a;
        o0 o0Var = (o0) linkedHashMap.get(str);
        if (!cls.isInstance(o0Var)) {
            t1.c cVar = new t1.c((a7.a) this.f890y);
            ((LinkedHashMap) cVar.f307w).put(p0.f1191b, str);
            try {
                o0VarA = r0Var.b(cls, cVar);
            } catch (AbstractMethodError unused) {
                o0VarA = r0Var.a(cls);
            }
            ge.i.e(o0VarA, "viewModel");
            o0 o0Var2 = (o0) linkedHashMap.put(str, o0VarA);
            if (o0Var2 != null) {
                o0Var2.b();
            }
            return o0VarA;
        }
        androidx.lifecycle.m0 m0Var = r0Var instanceof androidx.lifecycle.m0 ? (androidx.lifecycle.m0) r0Var : null;
        if (m0Var != null) {
            ge.i.b(o0Var);
            androidx.lifecycle.u uVar = m0Var.f1177d;
            if (uVar != null) {
                b5.e eVar = m0Var.f1178e;
                ge.i.b(eVar);
                androidx.lifecycle.i0.a(o0Var, eVar, uVar);
            }
        }
        ge.i.c(o0Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return o0Var;
    }

    public jd.a t(int i, md.n nVar) {
        jd.a aVar;
        ge.i.e(nVar, "reason");
        synchronized (this.f889x) {
            try {
                WeakReference weakReference = (WeakReference) ((LinkedHashMap) this.f890y).get(Integer.valueOf(i));
                aVar = weakReference != null ? (jd.a) weakReference.get() : null;
                if (aVar == null) {
                    aVar = new jd.a();
                    aVar.a(((id.a) this.f888w).f6439a.g(i), null, nVar);
                    ((LinkedHashMap) this.f890y).put(Integer.valueOf(i), new WeakReference(aVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public String toString() {
        switch (this.f887v) {
            case 2:
                String str = (String) this.f890y;
                String str2 = (String) this.f889x;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.f888w;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(uri.toString());
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void u(int i, dd.e eVar, md.n nVar) {
        ge.i.e(eVar, "download");
        ge.i.e(nVar, "reason");
        synchronized (this.f889x) {
            t(i, nVar).a(((id.a) this.f888w).a(i, eVar), eVar, nVar);
        }
    }

    public ImageHeaderParser$ImageType v() throws Throwable {
        switch (this.f887v) {
            case 16:
                return com.bumptech.glide.c.u((List) this.f889x, s7.b.c((ByteBuffer) this.f888w));
            case 17:
                List list = (List) this.f890y;
                g7.x xVar = (g7.x) ((com.bumptech.glide.load.data.h) this.f888w).f2236w;
                xVar.reset();
                return com.bumptech.glide.c.t(list, xVar, (a7.g) this.f889x);
            default:
                List list2 = (List) this.f889x;
                com.bumptech.glide.load.data.h hVar = (com.bumptech.glide.load.data.h) this.f890y;
                a7.g gVar = (a7.g) this.f888w;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    x6.d dVar = (x6.d) list2.get(i);
                    g7.x xVar2 = null;
                    try {
                        g7.x xVar3 = new g7.x(new FileInputStream(hVar.e().getFileDescriptor()), gVar);
                        try {
                            ImageHeaderParser$ImageType imageHeaderParser$ImageTypeE = dVar.e(xVar3);
                            xVar3.g();
                            hVar.e();
                            if (imageHeaderParser$ImageTypeE != ImageHeaderParser$ImageType.UNKNOWN) {
                                return imageHeaderParser$ImageTypeE;
                            }
                        } catch (Throwable th) {
                            th = th;
                            xVar2 = xVar3;
                            if (xVar2 != null) {
                                xVar2.g();
                            }
                            hVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public boolean w(CharSequence charSequence, int i, int i10, c0 c0Var) {
        if ((c0Var.f842c & 3) == 0) {
            i iVar = (i) this.f890y;
            l1.a aVarB = c0Var.b();
            int iA = aVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarB.f7627y).getShort(iA + aVarB.f7624v);
            }
            e eVar = (e) iVar;
            eVar.getClass();
            ThreadLocal threadLocal = e.f848b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i10) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = eVar.f849a;
            String string = sb.toString();
            int i11 = l0.d.f7606a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i12 = c0Var.f842c & 4;
            c0Var.f842c = zHasGlyph ? i12 | 2 : i12 | 1;
        }
        return (c0Var.f842c & 3) == 2;
    }

    /* JADX WARN: Finally extract failed */
    public boolean x() {
        switch (this.f887v) {
            case 16:
                List list = (List) this.f889x;
                ByteBuffer byteBufferC = s7.b.c((ByteBuffer) this.f888w);
                a7.g gVar = (a7.g) this.f890y;
                if (byteBufferC == null) {
                    return false;
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    try {
                        if (((x6.d) list.get(i)).d(byteBufferC, gVar)) {
                            return true;
                        }
                    } finally {
                    }
                }
                return false;
            case 17:
                List list2 = (List) this.f890y;
                g7.x xVar = (g7.x) ((com.bumptech.glide.load.data.h) this.f888w).f2236w;
                xVar.reset();
                a7.g gVar2 = (a7.g) this.f889x;
                xVar.mark(5242880);
                int size2 = list2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    try {
                        boolean zB = ((x6.d) list2.get(i10)).b(xVar, gVar2);
                        xVar.reset();
                        if (zB) {
                            return true;
                        }
                    } catch (Throwable th) {
                        xVar.reset();
                        throw th;
                    }
                }
                return false;
            default:
                List list3 = (List) this.f889x;
                com.bumptech.glide.load.data.h hVar = (com.bumptech.glide.load.data.h) this.f890y;
                a7.g gVar3 = (a7.g) this.f888w;
                int size3 = list3.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    x6.d dVar = (x6.d) list3.get(i11);
                    g7.x xVar2 = null;
                    try {
                        g7.x xVar3 = new g7.x(new FileInputStream(hVar.e().getFileDescriptor()), gVar3);
                        try {
                            boolean zB2 = dVar.b(xVar3, gVar3);
                            xVar3.g();
                            hVar.e();
                            if (zB2) {
                                return true;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            xVar2 = xVar3;
                            if (xVar2 != null) {
                                xVar2.g();
                            }
                            hVar.e();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return false;
        }
    }

    public boolean y(int i, a0.d dVar, d0.f fVar) {
        b0.b bVar = (b0.b) this.f889x;
        int[] iArr = dVar.f54p0;
        int[] iArr2 = dVar.f58t;
        bVar.f1585a = iArr[0];
        bVar.f1586b = iArr[1];
        bVar.f1587c = dVar.q();
        bVar.f1588d = dVar.k();
        bVar.i = false;
        bVar.f1592j = i;
        boolean z10 = bVar.f1585a == 3;
        boolean z11 = bVar.f1586b == 3;
        boolean z12 = z10 && dVar.W > 0.0f;
        boolean z13 = z11 && dVar.W > 0.0f;
        if (z12 && iArr2[0] == 4) {
            bVar.f1585a = 1;
        }
        if (z13 && iArr2[1] == 4) {
            bVar.f1586b = 1;
        }
        fVar.b(dVar, bVar);
        dVar.O(bVar.f1589e);
        dVar.L(bVar.f);
        dVar.E = bVar.f1591h;
        dVar.I(bVar.f1590g);
        bVar.f1592j = 0;
        return bVar.i;
    }

    public void z(int i, dd.e eVar, md.n nVar) {
        ge.i.e(eVar, "download");
        ge.i.e(nVar, "reason");
        synchronized (this.f889x) {
            try {
                WeakReference weakReference = (WeakReference) ((LinkedHashMap) this.f890y).get(Integer.valueOf(i));
                jd.a aVar = weakReference != null ? (jd.a) weakReference.get() : null;
                if (aVar != null) {
                    aVar.a(((id.a) this.f888w).a(i, eVar), eVar, nVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ v(Object obj, Object obj2, Object obj3, int i) {
        this.f887v = i;
        this.f888w = obj;
        this.f889x = obj2;
        this.f890y = obj3;
    }

    public v(int i) {
        this.f887v = i;
        switch (i) {
            case 29:
                this.f888w = new Object();
                break;
            default:
                this.f888w = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f889x = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f890y = new ArrayList();
                break;
        }
    }

    public v(Context context, r1 r1Var) {
        this.f887v = 11;
        this.f890y = new AtomicLong(-1L);
        this.f889x = new q8.c(context, q8.c.i, new o8.m("measurement:api"), m8.b.f8387b);
        this.f888w = r1Var;
    }

    public v(com.google.android.gms.internal.measurement.b bVar) {
        this.f887v = 5;
        this.f888w = bVar;
        this.f889x = bVar.clone();
        this.f890y = new ArrayList();
    }

    public v(id.a aVar) {
        this.f887v = 28;
        this.f888w = aVar;
        this.f889x = new Object();
        this.f890y = new LinkedHashMap();
    }

    public v(List list) {
        this.f887v = 24;
        this.f890y = list;
        this.f888w = new ArrayList(list.size());
        this.f889x = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ((ArrayList) this.f888w).add(new j6.n((List) ((n6.f) list.get(i)).f8800b.f307w));
            ((ArrayList) this.f889x).add(((n6.f) list.get(i)).f8801c.D0());
        }
    }

    public v(ArrayList arrayList) {
        this.f887v = 15;
        this.f888w = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f889x = new long[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            g4.c cVar = (g4.c) arrayList.get(i);
            int i10 = i * 2;
            long[] jArr = (long[]) this.f889x;
            jArr[i10] = cVar.f4999b;
            jArr[i10 + 1] = cVar.f5000c;
        }
        long[] jArr2 = (long[]) this.f889x;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f890y = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    private final void F() {
    }

    private final void G() {
    }

    public v(Intent intent) {
        this.f887v = 2;
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.f888w = data;
        this.f889x = action;
        this.f890y = type;
    }

    public v(t0 t0Var, androidx.lifecycle.r0 r0Var, a7.a aVar) {
        this.f887v = 1;
        ge.i.e(t0Var, "store");
        ge.i.e(r0Var, "factory");
        ge.i.e(aVar, "defaultCreationExtras");
        this.f888w = t0Var;
        this.f889x = r0Var;
        this.f890y = aVar;
    }

    public v(String str) {
        this.f887v = 20;
        v1.o oVar = new v1.o();
        oVar.f12892l = v1.m0.p("video/mp2t");
        oVar.f12893m = v1.m0.p(str);
        this.f888w = new v1.p(oVar);
    }

    public v(NavigationView navigationView) {
        Object dVar;
        this.f887v = 9;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            dVar = new ea.f();
        } else {
            dVar = i >= 33 ? new ea.d() : null;
        }
        this.f888w = dVar;
        this.f889x = navigationView;
        this.f890y = navigationView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(t0 t0Var, androidx.lifecycle.r0 r0Var) {
        this(t0Var, r0Var, t1.a.f11832x);
        this.f887v = 1;
        ge.i.e(t0Var, "store");
    }

    public v(Context context, LocationManager locationManager) {
        this.f887v = 19;
        this.f890y = new j0();
        this.f888w = context;
        this.f889x = locationManager;
    }

    public v(a0.e eVar) {
        this.f887v = 3;
        this.f888w = new ArrayList();
        this.f889x = new b0.b();
        this.f890y = eVar;
    }

    public v(byte[] bArr, ya.w wVar) {
        this.f887v = 26;
        this.f888w = bArr;
        this.f889x = null;
        this.f890y = wVar;
    }

    public v(Uri uri, ya.w wVar) {
        this.f887v = 26;
        this.f888w = null;
        this.f889x = uri;
        this.f890y = wVar;
    }

    public v(kf.u uVar) {
        this.f887v = 6;
        this.f889x = uVar;
        this.f888w = new l4.c0(8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public v(u0 u0Var) {
        androidx.lifecycle.r0 r0VarC;
        a7.a aVarD;
        this.f887v = 1;
        t0 t0VarE = u0Var.e();
        boolean z10 = u0Var instanceof androidx.lifecycle.i;
        if (z10) {
            r0VarC = ((androidx.lifecycle.i) u0Var).c();
        } else {
            if (androidx.lifecycle.s0.f1194a == null) {
                androidx.lifecycle.s0.f1194a = new androidx.lifecycle.s0();
            }
            r0VarC = androidx.lifecycle.s0.f1194a;
            ge.i.b(r0VarC);
        }
        if (z10) {
            aVarD = ((androidx.lifecycle.i) u0Var).d();
        } else {
            aVarD = t1.a.f11832x;
        }
        this(t0VarE, r0VarC, aVarD);
    }

    public v(b6.f fVar, fc.e eVar, e eVar2, Set set) {
        this.f887v = 0;
        this.f888w = eVar;
        this.f889x = fVar;
        this.f890y = eVar2;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            B(str, 0, str.length(), 1, true, new t(str, false));
        }
    }

    public v(w1.h[] hVarArr) {
        this.f887v = 21;
        i2.j0 j0Var = new i2.j0();
        w1.k kVar = new w1.k();
        kVar.f13824c = 1.0f;
        kVar.f13825d = 1.0f;
        w1.f fVar = w1.f.f13790e;
        kVar.f13826e = fVar;
        kVar.f = fVar;
        kVar.f13827g = fVar;
        kVar.f13828h = fVar;
        ByteBuffer byteBuffer = w1.h.f13795a;
        kVar.f13830k = byteBuffer;
        kVar.f13831l = byteBuffer.asShortBuffer();
        kVar.f13832m = byteBuffer;
        kVar.f13823b = -1;
        w1.h[] hVarArr2 = new w1.h[hVarArr.length + 2];
        this.f888w = hVarArr2;
        System.arraycopy(hVarArr, 0, hVarArr2, 0, hVarArr.length);
        this.f889x = j0Var;
        this.f890y = kVar;
        hVarArr2[hVarArr.length] = j0Var;
        hVarArr2[hVarArr.length + 1] = kVar;
    }

    public v(s7.j jVar, ArrayList arrayList, a7.g gVar) {
        this.f887v = 17;
        s7.f.c(gVar, "Argument must not be null");
        this.f889x = gVar;
        s7.f.c(arrayList, "Argument must not be null");
        this.f890y = arrayList;
        this.f888w = new com.bumptech.glide.load.data.h(jVar, gVar);
    }

    public v(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, a7.g gVar) {
        this.f887v = 18;
        s7.f.c(gVar, "Argument must not be null");
        this.f888w = gVar;
        s7.f.c(arrayList, "Argument must not be null");
        this.f889x = arrayList;
        this.f890y = new com.bumptech.glide.load.data.h(parcelFileDescriptor);
    }

    public v(AudioTrack audioTrack, i2.f fVar) {
        this.f887v = 22;
        this.f888w = audioTrack;
        this.f889x = fVar;
        this.f890y = new AudioRouting.OnRoutingChangedListener() { // from class: i2.b0
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                AudioDeviceInfo routedDevice;
                androidx.emoji2.text.v vVar = this.f5976a;
                if (((b0) vVar.f890y) == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
                    return;
                }
                ((f) vVar.f889x).f(routedDevice);
            }
        };
        audioTrack.addOnRoutingChangedListener((i2.b0) this.f890y, new Handler(Looper.myLooper()));
    }

    public v(i2.f0 f0Var) {
        this.f887v = 23;
        this.f890y = f0Var;
        this.f888w = new Handler(Looper.myLooper());
        this.f889x = new i2.e0(this);
    }
}
