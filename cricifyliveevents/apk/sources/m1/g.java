package m1;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends u8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f8031e;

    public g(TextView textView) {
        this.f8031e = new f(textView);
    }

    @Override // u8.a
    public final void A(boolean z10) {
        f fVar = this.f8031e;
        if (m.f863k != null) {
            fVar.A(z10);
        } else {
            fVar.f8030g = z10;
        }
    }

    @Override // u8.a
    public final TransformationMethod E(TransformationMethod transformationMethod) {
        return !(m.f863k != null) ? transformationMethod : this.f8031e.E(transformationMethod);
    }

    @Override // u8.a
    public final InputFilter[] s(InputFilter[] inputFilterArr) {
        return !(m.f863k != null) ? inputFilterArr : this.f8031e.s(inputFilterArr);
    }

    @Override // u8.a
    public final boolean u() {
        return this.f8031e.f8030g;
    }

    @Override // u8.a
    public final void z(boolean z10) {
        if (m.f863k != null) {
            this.f8031e.z(z10);
        }
    }
}
