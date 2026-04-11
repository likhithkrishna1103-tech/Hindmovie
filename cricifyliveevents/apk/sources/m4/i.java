package m4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f8176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f8177e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f8178g;

    public i(q qVar, String[] strArr, float[] fArr) {
        this.f8178g = qVar;
        this.f8176d = strArr;
        this.f8177e = fArr;
    }

    @Override // v4.z
    public final int a() {
        return this.f8176d.length;
    }

    @Override // v4.z
    public final void e(x0 x0Var, final int i) {
        m mVar = (m) x0Var;
        View view = mVar.f8188v;
        View view2 = mVar.f13387a;
        String[] strArr = this.f8176d;
        if (i < strArr.length) {
            mVar.f8187u.setText(strArr[i]);
        }
        if (i == this.f) {
            view2.setSelected(true);
            view.setVisibility(0);
        } else {
            view2.setSelected(false);
            view.setVisibility(4);
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: m4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                i iVar = this.f8174v;
                q qVar = iVar.f8178g;
                int i10 = iVar.f;
                int i11 = i;
                if (i11 != i10) {
                    qVar.setPlaybackSpeed(iVar.f8177e[i11]);
                }
                qVar.F.dismiss();
            }
        });
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        return new m(LayoutInflater.from(this.f8178g.getContext()).inflate(h0.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
