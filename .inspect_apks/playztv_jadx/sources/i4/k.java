package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f6229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f6230e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f6231g;

    public k(s sVar, String[] strArr, float[] fArr) {
        this.f6231g = sVar;
        this.f6229d = strArr;
        this.f6230e = fArr;
    }

    @Override // q4.z
    public final int a() {
        return this.f6229d.length;
    }

    @Override // q4.z
    public final void d(q4.x0 x0Var, final int i) {
        o oVar = (o) x0Var;
        View view = oVar.f6241v;
        View view2 = oVar.f10962a;
        String[] strArr = this.f6229d;
        if (i < strArr.length) {
            oVar.f6240u.setText(strArr[i]);
        }
        if (i == this.f) {
            view2.setSelected(true);
            view.setVisibility(0);
        } else {
            view2.setSelected(false);
            view.setVisibility(4);
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: i4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                k kVar = this.f6227u;
                s sVar = kVar.f6231g;
                int i10 = kVar.f;
                int i11 = i;
                if (i11 != i10) {
                    sVar.setPlaybackSpeed(kVar.f6230e[i11]);
                }
                sVar.E.dismiss();
            }
        });
    }

    @Override // q4.z
    public final q4.x0 e(ViewGroup viewGroup, int i) {
        return new o(LayoutInflater.from(this.f6231g.getContext()).inflate(j0.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
