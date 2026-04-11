package g5;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5308a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f5309b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f5310c = new ArrayList();

    public static void a(ViewGroup viewGroup, p pVar) {
        ArrayList arrayList = f5310c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (pVar == null) {
            pVar = f5308a;
        }
        p pVarClone = pVar.clone();
        ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((p) obj).w(viewGroup);
            }
        }
        pVarClone.h(viewGroup, true);
        if (viewGroup.getTag(j.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        viewGroup.setTag(j.transition_current_scene, null);
        s sVar = new s();
        sVar.f5306u = pVarClone;
        sVar.f5307v = viewGroup;
        viewGroup.addOnAttachStateChangeListener(sVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(sVar);
    }

    public static s.e b() {
        s.e eVar;
        ThreadLocal threadLocal = f5309b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (eVar = (s.e) weakReference.get()) != null) {
            return eVar;
        }
        s.e eVar2 = new s.e(0);
        threadLocal.set(new WeakReference(eVar2));
        return eVar2;
    }
}
