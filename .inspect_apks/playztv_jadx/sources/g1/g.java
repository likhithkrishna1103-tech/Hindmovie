package g1;

import android.text.InputFilter;
import android.widget.TextView;
import androidx.emoji2.text.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends i5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f4839j;

    public g(TextView textView) {
        this.f4839j = new f(textView);
    }

    @Override // i5.a
    public final void J(boolean z2) {
        if (m.f1181k != null) {
            this.f4839j.J(z2);
        }
    }

    @Override // i5.a
    public final void L(boolean z2) {
        f fVar = this.f4839j;
        if (m.f1181k != null) {
            fVar.L(z2);
        } else {
            fVar.f4838l = z2;
        }
    }

    @Override // i5.a
    public final InputFilter[] t(InputFilter[] inputFilterArr) {
        return !(m.f1181k != null) ? inputFilterArr : this.f4839j.t(inputFilterArr);
    }
}
