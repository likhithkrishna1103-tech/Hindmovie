package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1501a = new LinkedHashMap();

    public final void a() {
        for (o0 o0Var : this.f1501a.values()) {
            o0Var.f1492c = true;
            HashMap map = o0Var.f1490a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = o0Var.f1490a.values().iterator();
                        while (it.hasNext()) {
                            o0.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = o0Var.f1491b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = o0Var.f1491b.iterator();
                        while (it2.hasNext()) {
                            o0.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            o0Var.b();
        }
        this.f1501a.clear();
    }
}
