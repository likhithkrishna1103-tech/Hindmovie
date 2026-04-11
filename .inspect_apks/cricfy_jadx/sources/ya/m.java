package ya;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends vf.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Unsafe f14997e;
    public static final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f14998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f14999h;
    public static final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f15000j;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e9) {
                throw new RuntimeException("Could not initialize intrinsics", e9.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new l());
        }
        try {
            f14998g = unsafe.objectFieldOffset(o.class.getDeclaredField("x"));
            f = unsafe.objectFieldOffset(o.class.getDeclaredField("w"));
            f14999h = unsafe.objectFieldOffset(o.class.getDeclaredField("v"));
            i = unsafe.objectFieldOffset(n.class.getDeclaredField("a"));
            f15000j = unsafe.objectFieldOffset(n.class.getDeclaredField("b"));
            f14997e = unsafe;
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // vf.g
    public final c D(o oVar) {
        c cVar;
        c cVar2 = c.f14984d;
        do {
            cVar = oVar.f15007w;
            if (cVar2 == cVar) {
                break;
            }
        } while (!g(oVar, cVar, cVar2));
        return cVar;
    }

    @Override // vf.g
    public final n E(o oVar) {
        n nVar;
        n nVar2 = n.f15001c;
        do {
            nVar = oVar.f15008x;
            if (nVar2 == nVar) {
                break;
            }
        } while (!k(oVar, nVar, nVar2));
        return nVar;
    }

    @Override // vf.g
    public final void P(n nVar, n nVar2) {
        f14997e.putObject(nVar, f15000j, nVar2);
    }

    @Override // vf.g
    public final void R(n nVar, Thread thread) {
        f14997e.putObject(nVar, i, thread);
    }

    @Override // vf.g
    public final boolean g(o oVar, c cVar, c cVar2) {
        return j.a(f14997e, oVar, f, cVar, cVar2);
    }

    @Override // vf.g
    public final boolean i(o oVar, Object obj, Object obj2) {
        return k.a(f14997e, oVar, f14999h, obj, obj2);
    }

    @Override // vf.g
    public final boolean k(o oVar, n nVar, n nVar2) {
        return i.a(f14997e, oVar, f14998g, nVar, nVar2);
    }
}
