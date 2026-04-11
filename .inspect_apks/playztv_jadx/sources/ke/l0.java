package ke;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 implements Runnable, Comparable, h0 {
    private volatile Object _heap;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7706v;

    public final pe.w a() {
        Object obj = this._heap;
        if (obj instanceof pe.w) {
            return (pe.w) obj;
        }
        return null;
    }

    @Override // ke.h0
    public final void b() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                i4.o0 o0Var = x.f7741b;
                if (obj == o0Var) {
                    return;
                }
                m0 m0Var = obj instanceof m0 ? (m0) obj : null;
                if (m0Var != null) {
                    m0Var.b(this);
                }
                this._heap = o0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = this.f7705u - ((l0) obj).f7705u;
        if (j5 > 0) {
            return 1;
        }
        return j5 < 0 ? -1 : 0;
    }

    public final int d(long j5, m0 m0Var, n0 n0Var) {
        synchronized (this) {
            if (this._heap == x.f7741b) {
                return 2;
            }
            synchronized (m0Var) {
                try {
                    l0[] l0VarArr = m0Var.f10407a;
                    l0 l0Var = l0VarArr != null ? l0VarArr[0] : null;
                    if (n0.C.get(n0Var) != 0) {
                        return 1;
                    }
                    if (l0Var == null) {
                        m0Var.f7708c = j5;
                    } else {
                        long j8 = l0Var.f7705u;
                        if (j8 - j5 < 0) {
                            j5 = j8;
                        }
                        if (j5 - m0Var.f7708c > 0) {
                            m0Var.f7708c = j5;
                        }
                    }
                    long j10 = this.f7705u;
                    long j11 = m0Var.f7708c;
                    if (j10 - j11 < 0) {
                        this.f7705u = j11;
                    }
                    m0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void e(m0 m0Var) {
        if (this._heap == x.f7741b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = m0Var;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f7705u + ']';
    }
}
