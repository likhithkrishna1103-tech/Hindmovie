package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1197a = new LinkedHashMap();

    public final void a() {
        for (o0 o0Var : this.f1197a.values()) {
            o0Var.f1188c = true;
            HashMap map = o0Var.f1186a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = o0Var.f1186a.values().iterator();
                        while (it.hasNext()) {
                            o0.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = o0Var.f1187b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = o0Var.f1187b.iterator();
                        while (it2.hasNext()) {
                            o0.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            o0Var.b();
        }
        this.f1197a.clear();
    }
}
