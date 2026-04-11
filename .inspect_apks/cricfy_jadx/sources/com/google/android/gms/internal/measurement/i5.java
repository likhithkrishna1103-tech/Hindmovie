package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i5 extends u4 {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb;
    protected n6 zzc;

    public i5() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = n6.f;
    }

    public static i5 l(Class cls) {
        Map map = zzd;
        i5 i5Var = (i5) map.get(cls);
        if (i5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                i5Var = (i5) map.get(cls);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException("Class initialization cannot fail.", e9);
            }
        }
        if (i5Var != null) {
            return i5Var;
        }
        i5 i5Var2 = (i5) ((i5) s6.e(cls)).o(6);
        if (i5Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, i5Var2);
        return i5Var2;
    }

    public static void m(Class cls, i5 i5Var) {
        i5Var.f();
        zzd.put(cls, i5Var);
    }

    public static Object n(Method method, i5 i5Var, Object... objArr) {
        try {
            return method.invoke(i5Var, objArr);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e9);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    @Override // com.google.android.gms.internal.measurement.u4
    public final int b(j6 j6Var) {
        if (e()) {
            int iE = j6Var.e(this);
            if (iE >= 0) {
                return iE;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iE).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iE);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iE2 = j6Var.e(this);
        if (iE2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iE2;
            return iE2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iE2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iE2);
        throw new IllegalStateException(sb2.toString());
    }

    public final void d(b5 b5Var) {
        j6 j6VarA = g6.f2460c.a(getClass());
        w5 w5Var = b5Var.f2328e;
        if (w5Var == null) {
            w5Var = new w5(b5Var);
        }
        j6VarA.g(this, w5Var);
    }

    public final boolean e() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return g6.f2460c.a(getClass()).i(this, (i5) obj);
    }

    public final void f() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final void g() {
        g6.f2460c.a(getClass()).b(this);
        f();
    }

    public final h5 h() {
        return (h5) o(5);
    }

    public final int hashCode() {
        if (e()) {
            return g6.f2460c.a(getClass()).f(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iF = g6.f2460c.a(getClass()).f(this);
        this.zza = iF;
        return iF;
    }

    public final h5 i() {
        h5 h5Var = (h5) o(5);
        h5Var.f(this);
        return h5Var;
    }

    public final void j() {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final int k() {
        if (e()) {
            int iE = g6.f2460c.a(getClass()).e(this);
            if (iE >= 0) {
                return iE;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(iE).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(iE);
            throw new IllegalStateException(sb.toString());
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iE2 = g6.f2460c.a(getClass()).e(this);
        if (iE2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iE2;
            return iE2;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(iE2).length() + 42);
        sb2.append("serialized size must be non-negative, was ");
        sb2.append(iE2);
        throw new IllegalStateException(sb2.toString());
    }

    public abstract Object o(int i);

    public final String toString() {
        String string = super.toString();
        char[] cArr = b6.f2331a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        b6.b(this, sb, 0);
        return sb.toString();
    }
}
