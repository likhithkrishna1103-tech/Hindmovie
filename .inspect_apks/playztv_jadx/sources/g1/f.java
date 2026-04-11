package g1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i5.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f4836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f4837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4838l = true;

    public f(TextView textView) {
        this.f4836j = textView;
        this.f4837k = new d(textView);
    }

    @Override // i5.a
    public final void J(boolean z2) {
        if (z2) {
            T();
        }
    }

    @Override // i5.a
    public final void L(boolean z2) {
        this.f4838l = z2;
        T();
        TextView textView = this.f4836j;
        textView.setFilters(t(textView.getFilters()));
    }

    public final void T() {
        TextView textView = this.f4836j;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.f4838l) {
            if (!(transformationMethod instanceof j) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new j(transformationMethod);
            }
        } else if (transformationMethod instanceof j) {
            transformationMethod = ((j) transformationMethod).f4844u;
        }
        textView.setTransformationMethod(transformationMethod);
    }

    @Override // i5.a
    public final InputFilter[] t(InputFilter[] inputFilterArr) {
        if (!this.f4838l) {
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
            d dVar = this.f4837k;
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
}
