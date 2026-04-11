package q4;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((p0) ((Observable) this).mObservers.get(size)).f10896a;
            recyclerView.k(null);
            recyclerView.A0.f = true;
            recyclerView.Y(true);
            if (!recyclerView.f1670y.m()) {
                recyclerView.requestLayout();
            }
        }
    }

    public final void c(int i) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f10896a;
            recyclerView.k(null);
            n.p pVar = recyclerView.f1670y;
            ArrayList arrayList = (ArrayList) pVar.f8477c;
            arrayList.add(pVar.p(null, 4, i, 1));
            pVar.f8475a |= 4;
            if (arrayList.size() == 1) {
                p0Var.a();
            }
        }
    }

    public final void d(int i) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f10896a;
            recyclerView.k(null);
            n.p pVar = recyclerView.f1670y;
            ArrayList arrayList = (ArrayList) pVar.f8477c;
            arrayList.add(pVar.p(null, 1, i, 1));
            pVar.f8475a |= 1;
            if (arrayList.size() == 1) {
                p0Var.a();
            }
        }
    }

    public final void e(int i) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            p0 p0Var = (p0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = p0Var.f10896a;
            recyclerView.k(null);
            n.p pVar = recyclerView.f1670y;
            ArrayList arrayList = (ArrayList) pVar.f8477c;
            arrayList.add(pVar.p(null, 2, i, 1));
            pVar.f8475a |= 2;
            if (arrayList.size() == 1) {
                p0Var.a();
            }
        }
    }
}
