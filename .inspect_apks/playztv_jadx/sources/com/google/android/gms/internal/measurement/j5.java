package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j5 extends u4 {
    private static Map<Class<?>, j5> zzc = new ConcurrentHashMap();
    protected k6 zzb;
    private int zzd;

    public j5() {
        this.zza = 0;
        this.zzd = -1;
        this.zzb = k6.f;
    }

    public static j5 d(Class cls) {
        j5 j5Var = zzc.get(cls);
        if (j5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                j5Var = zzc.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (j5Var != null) {
            return j5Var;
        }
        j5 j5Var2 = (j5) ((j5) n6.a(cls)).e(6);
        if (j5Var2 == null) {
            throw new IllegalStateException();
        }
        zzc.put(cls, j5Var2);
        return j5Var2;
    }

    public static Object f(Method method, j5 j5Var, Object... objArr) {
        try {
            return method.invoke(j5Var, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void g(Class cls, j5 j5Var) {
        j5Var.l();
        zzc.put(cls, j5Var);
    }

    public static final boolean h(j5 j5Var, boolean z2) {
        byte bByteValue = ((Byte) j5Var.e(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        h6 h6Var = h6.f3037c;
        h6Var.getClass();
        boolean zB = h6Var.a(j5Var.getClass()).b(j5Var);
        if (z2) {
            j5Var.e(2);
        }
        return zB;
    }

    @Override // com.google.android.gms.internal.measurement.u4
    public final int a(j6 j6Var) {
        int iE;
        int iE2;
        if (m()) {
            if (j6Var == null) {
                h6 h6Var = h6.f3037c;
                h6Var.getClass();
                iE2 = h6Var.a(getClass()).e(this);
            } else {
                iE2 = j6Var.e(this);
            }
            if (iE2 >= 0) {
                return iE2;
            }
            throw new IllegalStateException(e6.j.l("serialized size must be non-negative, was ", iE2));
        }
        int i = this.zzd;
        if ((i & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & Integer.MAX_VALUE;
        }
        if (j6Var == null) {
            h6 h6Var2 = h6.f3037c;
            h6Var2.getClass();
            iE = h6Var2.a(getClass()).e(this);
        } else {
            iE = j6Var.e(this);
        }
        i(iE);
        return iE;
    }

    public abstract Object e(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h6 h6Var = h6.f3037c;
        h6Var.getClass();
        return h6Var.a(getClass()).g(this, (j5) obj);
    }

    public final int hashCode() {
        if (m()) {
            h6 h6Var = h6.f3037c;
            h6Var.getClass();
            return h6Var.a(getClass()).c(this);
        }
        if (this.zza == 0) {
            h6 h6Var2 = h6.f3037c;
            h6Var2.getClass();
            this.zza = h6Var2.a(getClass()).c(this);
        }
        return this.zza;
    }

    public final void i(int i) {
        if (i < 0) {
            throw new IllegalStateException(e6.j.l("serialized size must be non-negative, was ", i));
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    public final i5 j() {
        return (i5) e(5);
    }

    public final i5 k() {
        i5 i5Var = (i5) e(5);
        i5Var.a(this);
        return i5Var;
    }

    public final void l() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean m() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = b6.f2903a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        b6.b(this, sb2, 0);
        return sb2.toString();
    }
}
