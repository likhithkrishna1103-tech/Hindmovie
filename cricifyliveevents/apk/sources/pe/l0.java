package pe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 implements Runnable, Comparable, h0 {
    private volatile Object _heap;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f10248v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10249w = -1;

    public l0(long j4) {
        this.f10248v = j4;
    }

    public final ue.w a() {
        Object obj = this._heap;
        if (obj instanceof ue.w) {
            return (ue.w) obj;
        }
        return null;
    }

    @Override // pe.h0
    public final void b() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                d5.a aVar = x.f10282b;
                if (obj == aVar) {
                    return;
                }
                m0 m0Var = obj instanceof m0 ? (m0) obj : null;
                if (m0Var != null) {
                    m0Var.b(this);
                }
                this._heap = aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j4 = this.f10248v - ((l0) obj).f10248v;
        if (j4 > 0) {
            return 1;
        }
        return j4 < 0 ? -1 : 0;
    }

    public final int d(long j4, m0 m0Var, n0 n0Var) {
        synchronized (this) {
            if (this._heap == x.f10282b) {
                return 2;
            }
            synchronized (m0Var) {
                try {
                    l0[] l0VarArr = m0Var.f12493a;
                    l0 l0Var = l0VarArr != null ? l0VarArr[0] : null;
                    if (n0.D.get(n0Var) != 0) {
                        return 1;
                    }
                    if (l0Var == null) {
                        m0Var.f10251c = j4;
                    } else {
                        long j7 = l0Var.f10248v;
                        if (j7 - j4 < 0) {
                            j4 = j7;
                        }
                        if (j4 - m0Var.f10251c > 0) {
                            m0Var.f10251c = j4;
                        }
                    }
                    long j10 = this.f10248v;
                    long j11 = m0Var.f10251c;
                    if (j10 - j11 < 0) {
                        this.f10248v = j11;
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
        if (this._heap == x.f10282b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = m0Var;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f10248v + ']';
    }
}
