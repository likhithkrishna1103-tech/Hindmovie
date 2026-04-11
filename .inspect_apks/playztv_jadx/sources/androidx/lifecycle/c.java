package androidx.lifecycle;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f1448b;

    public c(int i, Method method) {
        this.f1447a = i;
        this.f1448b = method;
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
        return this.f1447a == cVar.f1447a && this.f1448b.getName().equals(cVar.f1448b.getName());
    }

    public final int hashCode() {
        return this.f1448b.getName().hashCode() + (this.f1447a * 31);
    }
}
