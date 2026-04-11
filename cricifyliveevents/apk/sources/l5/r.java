package l5;

import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f7824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList f7825c;

    static {
        a aVar = new a();
        aVar.V = new ArrayList();
        aVar.Y = false;
        aVar.Z = 0;
        aVar.W = false;
        aVar.I(new h(2));
        aVar.I(new f());
        aVar.I(new h(1));
        f7823a = aVar;
        f7824b = new ThreadLocal();
        f7825c = new ArrayList();
    }

    public static void a(FrameLayout frameLayout, n nVar) {
        ArrayList arrayList = f7825c;
        if (arrayList.contains(frameLayout) || !frameLayout.isLaidOut()) {
            return;
        }
        arrayList.add(frameLayout);
        if (nVar == null) {
            nVar = f7823a;
        }
        n nVarClone = nVar.clone();
        ArrayList arrayList2 = (ArrayList) b().get(frameLayout);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((n) obj).w(frameLayout);
            }
        }
        nVarClone.h(frameLayout, true);
        if (frameLayout.getTag(j.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        frameLayout.setTag(j.transition_current_scene, null);
        q qVar = new q();
        qVar.f7821v = nVarClone;
        qVar.f7822w = frameLayout;
        frameLayout.addOnAttachStateChangeListener(qVar);
        frameLayout.getViewTreeObserver().addOnPreDrawListener(qVar);
    }

    public static v.e b() {
        v.e eVar;
        ThreadLocal threadLocal = f7824b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (eVar = (v.e) weakReference.get()) != null) {
            return eVar;
        }
        v.e eVar2 = new v.e(0);
        threadLocal.set(new WeakReference(eVar2));
        return eVar2;
    }
}
