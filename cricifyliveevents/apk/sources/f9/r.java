package f9;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements of.h {
    public final Object A;
    public final Object B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4358v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4359w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4360x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4361y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f4362z;

    public r(r1 r1Var, String str, String str2, String str3, long j4, long j7, Bundle bundle) {
        u uVar;
        o8.u.d(str2);
        o8.u.d(str3);
        this.f4361y = str2;
        this.f4362z = str3;
        this.A = true == TextUtils.isEmpty(str) ? null : str;
        this.f4359w = j4;
        this.f4360x = j7;
        if (j7 != 0 && j7 > j4) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.E.b(w0.u1(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            uVar = new u(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    w0 w0Var2 = r1Var.A;
                    r1.g(w0Var2);
                    w0Var2.B.a("Param name can't be null");
                    it.remove();
                } else {
                    u4 u4Var = r1Var.D;
                    r1.e(u4Var);
                    Object objT1 = u4Var.t1(bundle2.get(next), next);
                    if (objT1 == null) {
                        w0 w0Var3 = r1Var.A;
                        r1.g(w0Var3);
                        w0Var3.E.b(r1Var.E.b(next), "Param value can't be null");
                        it.remove();
                    } else {
                        u4 u4Var2 = r1Var.D;
                        r1.e(u4Var2);
                        u4Var2.B1(bundle2, next, objT1);
                    }
                }
            }
            uVar = new u(bundle2);
        }
        this.B = uVar;
    }

    public void a() {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.A;
        Iterator it = copyOnWriteArrayList.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            of.s sVar = (of.s) it.next();
            sVar.cancel();
            of.s sVarC = sVar.c();
            if (sVarC != null) {
                ((of.p) this.f4361y).f9849p.addLast(sVarC);
            }
        }
        copyOnWriteArrayList.clear();
    }

    public r b(long j4, k2.m mVar) throws s2.b {
        long jC;
        long jC2;
        j2.i iVarD = ((k2.m) this.f4362z).d();
        j2.i iVarD2 = mVar.d();
        if (iVarD == null) {
            return new r(j4, mVar, (k2.b) this.A, (t2.d) this.f4361y, this.f4360x, iVarD);
        }
        if (!iVarD.o()) {
            return new r(j4, mVar, (k2.b) this.A, (t2.d) this.f4361y, this.f4360x, iVarD2);
        }
        long jU = iVarD.u(j4);
        if (jU == 0) {
            return new r(j4, mVar, (k2.b) this.A, (t2.d) this.f4361y, this.f4360x, iVarD2);
        }
        y1.d.h(iVarD2);
        long jQ = iVarD.q();
        long jB = iVarD.b(jQ);
        long j7 = jU + jQ;
        long j10 = j7 - 1;
        long jF = iVarD.f(j10, j4) + iVarD.b(j10);
        long jQ2 = iVarD2.q();
        long jB2 = iVarD2.b(jQ2);
        long j11 = this.f4360x;
        if (jF == jB2) {
            jC = j7 - jQ2;
        } else {
            if (jF < jB2) {
                throw new s2.b();
            }
            if (jB2 < jB) {
                jC2 = j11 - (iVarD2.c(jB, j4) - jQ);
                return new r(j4, mVar, (k2.b) this.A, (t2.d) this.f4361y, jC2, iVarD2);
            }
            jC = iVarD.c(jB2, j4) - jQ2;
        }
        jC2 = jC + j11;
        return new r(j4, mVar, (k2.b) this.A, (t2.d) this.f4361y, jC2, iVarD2);
    }

    public long c(long j4) {
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return iVar.h(this.f4359w, j4) + this.f4360x;
    }

    public long d(long j4) {
        long jC = c(j4);
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return (iVar.w(this.f4359w, j4) + jC) - 1;
    }

    public long e() {
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return iVar.u(this.f4359w);
    }

    public long f(long j4) {
        long jG = g(j4);
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return iVar.f(j4 - this.f4360x, this.f4359w) + jG;
    }

    public long g(long j4) {
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return iVar.b(j4 - this.f4360x);
    }

    @Override // of.h
    public of.o h() throws IOException {
        of.r rVarJ;
        long j4;
        of.r rVar;
        IOException iOException = null;
        while (true) {
            try {
                if (((CopyOnWriteArrayList) this.A).isEmpty() && !((of.p) this.f4361y).a(null)) {
                    a();
                    ge.i.b(iOException);
                    throw iOException;
                }
                if (((of.p) this.f4361y).f9844k.K) {
                    throw new IOException("Canceled");
                }
                m2.e eVar = ((nf.d) this.f4362z).f9160a;
                long jNanoTime = System.nanoTime();
                long j7 = this.f4360x - jNanoTime;
                if (((CopyOnWriteArrayList) this.A).isEmpty() || j7 <= 0) {
                    rVarJ = j();
                    j4 = this.f4359w;
                    this.f4360x = jNanoTime + j4;
                } else {
                    j4 = j7;
                    rVarJ = null;
                }
                if (rVarJ == null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.A;
                    if (copyOnWriteArrayList.isEmpty() || (rVar = (of.r) ((LinkedBlockingDeque) this.B).poll(j4, timeUnit)) == null) {
                        rVarJ = null;
                    } else {
                        copyOnWriteArrayList.remove(rVar.f9851a);
                        rVarJ = rVar;
                    }
                    if (rVarJ == null) {
                    }
                }
                boolean z10 = false;
                if (rVarJ.f9852b == null && rVarJ.f9853c == null) {
                    a();
                    if (!rVarJ.f9851a.b()) {
                        rVarJ = rVarJ.f9851a.d();
                    }
                    if (rVarJ.f9852b == null && rVarJ.f9853c == null) {
                        z10 = true;
                    }
                    if (z10) {
                        return rVarJ.f9851a.e();
                    }
                }
                Throwable th = rVarJ.f9853c;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        throw th;
                    }
                    if (iOException == null) {
                        iOException = (IOException) th;
                    } else {
                        ab.b.c(iOException, th);
                    }
                }
                of.s sVar = rVarJ.f9852b;
                if (sVar != null) {
                    ((of.p) this.f4361y).f9849p.addFirst(sVar);
                }
            } finally {
                a();
            }
        }
    }

    public boolean i(long j4, long j7) {
        j2.i iVar = (j2.i) this.B;
        y1.d.h(iVar);
        return iVar.o() || j7 == -9223372036854775807L || f(j4) <= j7;
    }

    public of.r j() {
        of.s iVar;
        of.p pVar = (of.p) this.f4361y;
        if (pVar.a(null)) {
            try {
                iVar = pVar.b();
            } catch (Throwable th) {
                iVar = new of.i(th);
            }
            if (iVar.b()) {
                return new of.r(iVar, (Throwable) null, 6);
            }
            if (iVar instanceof of.i) {
                return ((of.i) iVar).f9810a;
            }
            ((CopyOnWriteArrayList) this.A).add(iVar);
            ((nf.d) this.f4362z).d().d(new of.j(lf.f.f7965b + " connect " + pVar.i.f7432h.f(), iVar, this), 0L);
        }
        return null;
    }

    public r k(r1 r1Var, long j4) {
        return new r(r1Var, (String) this.A, (String) this.f4361y, (String) this.f4362z, this.f4359w, j4, (u) this.B);
    }

    @Override // of.h
    public of.p l() {
        return (of.p) this.f4361y;
    }

    public String toString() {
        switch (this.f4358v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String string = ((u) this.B).toString();
                String str = (String) this.f4361y;
                int length = String.valueOf(str).length();
                String str2 = (String) this.f4362z;
                StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
                sb.append("Event{appId='");
                sb.append(str);
                sb.append("', name='");
                sb.append(str2);
                sb.append("', params=");
                sb.append(string);
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public r(r1 r1Var, String str, String str2, String str3, long j4, long j7, u uVar) {
        o8.u.d(str2);
        o8.u.d(str3);
        o8.u.g(uVar);
        this.f4361y = str2;
        this.f4362z = str3;
        this.A = true == TextUtils.isEmpty(str) ? null : str;
        this.f4359w = j4;
        this.f4360x = j7;
        if (j7 != 0 && j7 > j4) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.E.c(w0.u1(str2), w0.u1(str3), "Event created with reverse previous/current timestamps. appId, name");
        }
        this.B = uVar;
    }

    public r(of.p pVar, nf.d dVar) {
        ge.i.e(dVar, "taskRunner");
        this.f4361y = pVar;
        this.f4362z = dVar;
        this.f4359w = TimeUnit.MILLISECONDS.toNanos(250L);
        this.f4360x = Long.MIN_VALUE;
        this.A = new CopyOnWriteArrayList();
        this.B = new LinkedBlockingDeque();
    }

    public r(long j4, k2.m mVar, k2.b bVar, t2.d dVar, long j7, j2.i iVar) {
        this.f4359w = j4;
        this.f4362z = mVar;
        this.A = bVar;
        this.f4360x = j7;
        this.f4361y = dVar;
        this.B = iVar;
    }
}
