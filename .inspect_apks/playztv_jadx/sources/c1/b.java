package c1;

import be.h;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import od.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2232b;

    public b(LinkedHashMap linkedHashMap, boolean z2) {
        this.f2231a = linkedHashMap;
        this.f2232b = new AtomicBoolean(z2);
    }

    public final Object a(d dVar) {
        h.e(dVar, "key");
        return this.f2231a.get(dVar);
    }

    public final void b(d dVar, Object obj) {
        h.e(dVar, "key");
        AtomicBoolean atomicBoolean = this.f2232b;
        if (atomicBoolean.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
        LinkedHashMap linkedHashMap = this.f2231a;
        if (obj == null) {
            if (atomicBoolean.get()) {
                throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
            }
            linkedHashMap.remove(dVar);
        } else {
            if (!(obj instanceof Set)) {
                linkedHashMap.put(dVar, obj);
                return;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(i.j0((Iterable) obj));
            h.d(setUnmodifiableSet, "unmodifiableSet(value.toSet())");
            linkedHashMap.put(dVar, setUnmodifiableSet);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return h.a(this.f2231a, ((b) obj).f2231a);
    }

    public final int hashCode() {
        return this.f2231a.hashCode();
    }

    public final String toString() {
        return i.b0(this.f2231a.entrySet(), ",\n", "{\n", "\n}", a.f2230v, 24);
    }

    public /* synthetic */ b(boolean z2) {
        this(new LinkedHashMap(), z2);
    }
}
