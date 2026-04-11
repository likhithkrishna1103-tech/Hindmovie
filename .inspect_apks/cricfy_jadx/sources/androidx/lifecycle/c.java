package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f1146b;

    public c(int i, Method method) {
        this.f1145a = i;
        this.f1146b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1145a == cVar.f1145a && this.f1146b.getName().equals(cVar.f1146b.getName());
    }

    public final int hashCode() {
        return this.f1146b.getName().hashCode() + (this.f1145a * 31);
    }
}
