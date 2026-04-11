package r4;

import android.database.SQLException;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends td.g implements ae.p {
    public /* synthetic */ Object A;
    public final /* synthetic */ g0 B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f11427y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11428z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(g0 g0Var, rd.c cVar, int i) {
        super(2, cVar);
        this.f11427y = i;
        this.B = g0Var;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        switch (this.f11427y) {
        }
        return ((b0) m((y) obj, (rd.c) obj2)).o(nd.k.f8990a);
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        switch (this.f11427y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = new b0(this.B, cVar, 0);
                b0Var.A = obj;
                return b0Var;
            case 1:
                b0 b0Var2 = new b0(this.B, cVar, 1);
                b0Var2.A = obj;
                return b0Var2;
            default:
                b0 b0Var3 = new b0(this.B, cVar, 2);
                b0Var3.A = obj;
                return b0Var3;
        }
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        y yVar;
        Object objB;
        Object objD;
        y yVar2;
        Object objB2;
        j[] jVarArr;
        j jVar;
        switch (this.f11427y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f11428z;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                    return obj;
                }
                i5.a.Q(obj);
                t4.j jVar2 = (t4.j) this.A;
                this.f11428z = 1;
                Object objA = g0.a(this.B, jVar2, this);
                sd.a aVar = sd.a.f11942u;
                return objA == aVar ? aVar : objA;
            case 1:
                int i10 = this.f11428z;
                sd.a aVar2 = sd.a.f11942u;
                try {
                    if (i10 == 0) {
                        i5.a.Q(obj);
                        yVar = (y) this.A;
                        this.A = yVar;
                        this.f11428z = 1;
                        objB = yVar.b(this);
                        if (objB == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            i5.a.Q(obj);
                            objD = obj;
                            return (Set) objD;
                        }
                        yVar = (y) this.A;
                        i5.a.Q(obj);
                        objB = obj;
                    }
                    if (!((Boolean) objB).booleanValue()) {
                        x xVar = x.f11513v;
                        b0 b0Var = new b0(this.B, null, 0);
                        this.A = null;
                        this.f11428z = 2;
                        objD = yVar.d(xVar, b0Var, this);
                        if (objD == aVar2) {
                            return aVar2;
                        }
                        return (Set) objD;
                    }
                } catch (SQLException unused) {
                }
                return od.s.f9572u;
            default:
                int i11 = this.f11428z;
                nd.k kVar = nd.k.f8990a;
                boolean z2 = true;
                sd.a aVar3 = sd.a.f11942u;
                if (i11 == 0) {
                    i5.a.Q(obj);
                    yVar2 = (y) this.A;
                    this.A = yVar2;
                    this.f11428z = 1;
                    objB2 = yVar2.b(this);
                    if (objB2 != aVar3) {
                    }
                    return aVar3;
                }
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i5.a.Q(obj);
                    return kVar;
                }
                yVar2 = (y) this.A;
                i5.a.Q(obj);
                objB2 = obj;
                if (((Boolean) objB2).booleanValue()) {
                    return kVar;
                }
                g0 g0Var = this.B;
                a2.c cVar = g0Var.f11457g;
                long[] jArr = (long[]) cVar.f174w;
                ReentrantLock reentrantLock = (ReentrantLock) cVar.f173v;
                reentrantLock.lock();
                try {
                    if (cVar.f172u) {
                        boolean z10 = false;
                        cVar.f172u = false;
                        int length = jArr.length;
                        jVarArr = new j[length];
                        int i12 = 0;
                        boolean z11 = false;
                        while (i12 < length) {
                            if (jArr[i12] <= 0) {
                                z2 = z10;
                            }
                            boolean[] zArr = (boolean[]) cVar.f175x;
                            if (z2 != zArr[i12]) {
                                zArr[i12] = z2;
                                jVar = z2 ? j.f11463v : j.f11464w;
                                z11 = true;
                            } else {
                                jVar = j.f11462u;
                            }
                            jVarArr[i12] = jVar;
                            i12++;
                            z2 = true;
                            z10 = false;
                        }
                        if (!z11) {
                            jVarArr = null;
                        }
                        reentrantLock.unlock();
                    } else {
                        reentrantLock.unlock();
                        jVarArr = null;
                    }
                    if (jVarArr == null) {
                        return kVar;
                    }
                    f0 f0Var = new f0(jVarArr, g0Var, yVar2, null);
                    this.A = null;
                    this.f11428z = 2;
                    if (yVar2.d(x.f11513v, f0Var, this) != aVar3) {
                        return kVar;
                    }
                    return aVar3;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
        }
    }
}
