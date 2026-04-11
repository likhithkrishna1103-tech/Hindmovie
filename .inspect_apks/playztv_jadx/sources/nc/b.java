package nc;

import android.content.SharedPreferences;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8919v;

    public /* synthetic */ b(int i, Object obj) {
        this.f8918u = i;
        this.f8919v = obj;
    }

    private final void a() {
        zc.c cVar = (zc.c) this.f8919v;
        synchronized (((ArrayDeque) cVar.f14948x)) {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) cVar.f14945u).edit();
            String str = (String) cVar.f14946v;
            StringBuilder sb2 = new StringBuilder();
            Iterator it = ((ArrayDeque) cVar.f14948x).iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
                sb2.append((String) cVar.f14947w);
            }
            editorEdit.putString(str, sb2.toString()).commit();
        }
    }

    private final void b() {
        a2.c cVar = (a2.c) this.f8919v;
        Map mapA = null;
        ((AtomicReference) cVar.f174w).set(null);
        synchronized (cVar) {
            try {
                if (((AtomicMarkableReference) cVar.f173v).isMarked()) {
                    mapA = ((va.d) ((AtomicMarkableReference) cVar.f173v).getReference()).a();
                    AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) cVar.f173v;
                    atomicMarkableReference.set((va.d) atomicMarkableReference.getReference(), false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mapA != null) {
            za.c cVar2 = (za.c) cVar.f175x;
            ((va.h) cVar2.f14935b).g((String) cVar2.f14934a, mapA, cVar.f172u);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0119 A[Catch: all -> 0x00e1, TryCatch #0 {, blocks: (B:43:0x00d6, B:45:0x00da, B:52:0x00e6, B:56:0x00ed, B:61:0x00f6, B:63:0x00fa, B:65:0x0100, B:67:0x010a, B:69:0x0114, B:71:0x0125, B:70:0x0119, B:72:0x0127, B:74:0x013a, B:76:0x0142), top: B:132:0x00d6 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.b.run():void");
    }
}
