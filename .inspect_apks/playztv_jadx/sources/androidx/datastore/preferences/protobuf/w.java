package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends a {
    private static Map<Object, w> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize;
    protected j1 unknownFields;

    public w() {
        this.memoizedHashCode = 0;
        this.unknownFields = j1.f;
        this.memoizedSerializedSize = -1;
    }

    public static w e(Class cls) {
        w wVar = defaultInstanceMap.get(cls);
        if (wVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                wVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = (w) ((w) s1.a(cls)).d(6);
        if (wVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, wVar2);
        return wVar2;
    }

    public static Object f(Method method, w wVar, Object... objArr) {
        try {
            return method.invoke(wVar, objArr);
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

    public static void h(Class cls, w wVar) {
        defaultInstanceMap.put(cls, wVar);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a() {
        if (this.memoizedSerializedSize == -1) {
            y0 y0Var = y0.f1144c;
            y0Var.getClass();
            this.memoizedSerializedSize = y0Var.a(getClass()).d(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void c(k kVar) {
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        b1 b1VarA = y0Var.a(getClass());
        k0 k0Var = kVar.f1077c;
        if (k0Var == null) {
            k0Var = new k0(kVar);
        }
        b1VarA.a(this, k0Var);
    }

    public abstract Object d(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((w) d(6)).getClass().isInstance(obj)) {
            return false;
        }
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        return y0Var.a(getClass()).f(this, (w) obj);
    }

    public final boolean g() {
        byte bByteValue = ((Byte) d(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        boolean zE = y0Var.a(getClass()).e(this);
        d(2);
        return zE;
    }

    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        y0 y0Var = y0.f1144c;
        y0Var.getClass();
        int iB = y0Var.a(getClass()).b(this);
        this.memoizedHashCode = iB;
        return iB;
    }

    public final String toString() {
        String string = super.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        r0.k(this, sb2, 0);
        return sb2.toString();
    }
}
