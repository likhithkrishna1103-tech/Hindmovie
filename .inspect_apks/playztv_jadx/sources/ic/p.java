package ic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import q4.x0;
import q4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f6537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f6538e;
    public final o f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f6540h;

    public p(Context context, ArrayList arrayList, o oVar) {
        this.f6537d = context;
        this.f6538e = arrayList;
        this.f = oVar;
    }

    @Override // q4.z
    public final int a() {
        return this.f6538e.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final void d(x0 x0Var, final int i) {
        final n nVar = (n) x0Var;
        final oc.f fVar = (oc.f) this.f6538e.get(i);
        Chip chip = nVar.f6536u;
        chip.setText(fVar.f9540u);
        if (i == this.f6539g) {
            chip.setChecked(true);
            this.f6540h = nVar;
        } else {
            chip.setChecked(false);
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: ic.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p pVar = this.f6532u;
                pVar.f6540h.f6536u.setChecked(false);
                n nVar2 = nVar;
                nVar2.f6536u.setChecked(true);
                pVar.f6539g = i;
                pVar.f6540h = nVar2;
                oc.f fVar2 = fVar;
                pVar.f.a(fVar2.f9541v.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), fVar2.f9542w, fVar2.f9543x, fVar2.f9544y, fVar2.f9545z, fVar2.A);
            }
        });
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(this.f6537d).inflate(gc.k.item_link, viewGroup, false);
        n nVar = new n(viewInflate);
        nVar.f6536u = (Chip) viewInflate;
        return nVar;
    }

    @Override // q4.z
    public final int c(int i) {
        return i;
    }
}
