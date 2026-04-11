package m1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends u8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f8029e;
    public final d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8030g = true;

    public f(TextView textView) {
        this.f8029e = textView;
        this.f = new d(textView);
    }

    @Override // u8.a
    public final void A(boolean z10) {
        this.f8030g = z10;
        TextView textView = this.f8029e;
        textView.setTransformationMethod(E(textView.getTransformationMethod()));
        textView.setFilters(s(textView.getFilters()));
    }

    @Override // u8.a
    public final TransformationMethod E(TransformationMethod transformationMethod) {
        return this.f8030g ? ((transformationMethod instanceof j) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new j(transformationMethod) : transformationMethod instanceof j ? ((j) transformationMethod).f8037v : transformationMethod;
    }

    @Override // u8.a
    public final InputFilter[] s(InputFilter[] inputFilterArr) {
        if (!this.f8030g) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof d) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArray.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i12 = 0;
        while (true) {
            d dVar = this.f;
            if (i12 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i12] == dVar) {
                return inputFilterArr;
            }
            i12++;
        }
    }

    @Override // u8.a
    public final boolean u() {
        return this.f8030g;
    }

    @Override // u8.a
    public final void z(boolean z10) {
        if (z10) {
            TextView textView = this.f8029e;
            textView.setTransformationMethod(E(textView.getTransformationMethod()));
        }
    }
}
