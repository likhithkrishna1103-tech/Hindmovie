package ea;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f4614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f4616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f4617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f4618e;
    public static final long f;

    static {
        Unsafe unsafe;
        try {
            try {
                unsafe = Unsafe.getUnsafe();
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        } catch (SecurityException unused) {
            unsafe = (Unsafe) AccessController.doPrivileged(new m());
        }
        try {
            f4616c = unsafe.objectFieldOffset(p.class.getDeclaredField("w"));
            f4615b = unsafe.objectFieldOffset(p.class.getDeclaredField("v"));
            f4617d = unsafe.objectFieldOffset(p.class.getDeclaredField("u"));
            f4618e = unsafe.objectFieldOffset(o.class.getDeclaredField("a"));
            f = unsafe.objectFieldOffset(o.class.getDeclaredField("b"));
            f4614a = unsafe;
        } catch (NoSuchFieldException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // android.support.v4.media.session.b
    public final void M(o oVar, o oVar2) {
        f4614a.putObject(oVar, f, oVar2);
    }

    @Override // android.support.v4.media.session.b
    public final void N(o oVar, Thread thread) {
        f4614a.putObject(oVar, f4618e, thread);
    }

    @Override // android.support.v4.media.session.b
    public final boolean e(p pVar, d dVar, d dVar2) {
        return k.a(f4614a, pVar, f4615b, dVar, dVar2);
    }

    @Override // android.support.v4.media.session.b
    public final boolean f(p pVar, Object obj, Object obj2) {
        return l.a(f4614a, pVar, f4617d, obj, obj2);
    }

    @Override // android.support.v4.media.session.b
    public final boolean g(p pVar, o oVar, o oVar2) {
        return j.a(f4614a, pVar, f4616c, oVar, oVar2);
    }

    @Override // android.support.v4.media.session.b
    public final d p(p pVar) {
        d dVar;
        d dVar2 = d.f4598d;
        do {
            dVar = pVar.f4626v;
            if (dVar2 == dVar) {
                break;
            }
        } while (!e(pVar, dVar, dVar2));
        return dVar;
    }

    @Override // android.support.v4.media.session.b
    public final o q(p pVar) {
        o oVar;
        o oVar2 = o.f4619c;
        do {
            oVar = pVar.f4627w;
            if (oVar2 == oVar) {
                break;
            }
        } while (!g(pVar, oVar, oVar2));
        return oVar;
    }
}
