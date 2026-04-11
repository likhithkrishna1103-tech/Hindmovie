package v4;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((p0) ((Observable) this).mObservers.get(size)).f13325a;
            recyclerView.k(null);
            recyclerView.B0.f = true;
            recyclerView.Y(true);
            if (!recyclerView.f1455z.y()) {
                recyclerView.requestLayout();
            }
        }
    }

    public final void c(int i, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f13325a;
            recyclerView.k(null);
            ff.k kVar = recyclerView.f1455z;
            ArrayList arrayList = (ArrayList) kVar.f4588c;
            if (i10 >= 1) {
                arrayList.add(kVar.A(null, 4, i, i10));
                kVar.f4586a |= 4;
                if (arrayList.size() == 1) {
                    p0Var.a();
                }
            }
        }
    }

    public final void d(int i) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f13325a;
            recyclerView.k(null);
            ff.k kVar = recyclerView.f1455z;
            ArrayList arrayList = (ArrayList) kVar.f4588c;
            arrayList.add(kVar.A(null, 1, i, 1));
            kVar.f4586a |= 1;
            if (arrayList.size() == 1) {
                p0Var.a();
            }
        }
    }

    public final void e(int i) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f13325a;
            recyclerView.k(null);
            ff.k kVar = recyclerView.f1455z;
            ArrayList arrayList = (ArrayList) kVar.f4588c;
            arrayList.add(kVar.A(null, 2, i, 1));
            kVar.f4586a |= 2;
            if (arrayList.size() == 1) {
                p0Var.a();
            }
        }
    }
}
