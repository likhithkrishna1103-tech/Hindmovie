package s5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import v4.x0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f11511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f11512e;
    public final m f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f11514h;

    public n(Context context, ArrayList arrayList, m mVar) {
        this.f11511d = context;
        this.f11512e = arrayList;
        this.f = mVar;
    }

    @Override // v4.z
    public final int a() {
        return this.f11512e.size();
    }

    @Override // v4.z
    public final long b(int i) {
        return i;
    }

    @Override // v4.z
    public final void e(x0 x0Var, final int i) {
        final l lVar = (l) x0Var;
        final y5.g gVar = (y5.g) this.f11512e.get(i);
        Chip chip = lVar.f11510u;
        chip.setText(gVar.f14938v);
        if (i == this.f11513g) {
            chip.setChecked(true);
            this.f11514h = lVar;
        } else {
            chip.setChecked(false);
        }
        chip.setOnClickListener(new View.OnClickListener() { // from class: s5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n nVar = this.f11506v;
                nVar.f11514h.f11510u.setChecked(false);
                l lVar2 = lVar;
                lVar2.f11510u.setChecked(true);
                nVar.f11513g = i;
                nVar.f11514h = lVar2;
                y5.g gVar2 = gVar;
                nVar.f.b(gVar2.f14939w.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), gVar2.f14940x, gVar2.f14941y, gVar2.f14942z, gVar2.A, gVar2.B);
            }
        });
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(this.f11511d).inflate(q5.l.item_link, viewGroup, false);
        l lVar = new l(viewInflate);
        lVar.f11510u = (Chip) viewInflate;
        return lVar;
    }

    @Override // v4.z
    public final int c(int i) {
        return i;
    }
}
