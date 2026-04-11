package p2;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Comparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9971v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f9972w;

    public /* synthetic */ s(int i, Object obj) {
        this.f9971v = i;
        this.f9972w = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f9971v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w wVar = (w) this.f9972w;
                return wVar.e(obj2) - wVar.e(obj);
            case 1:
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f9972w;
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int iCompareTo = Boolean.valueOf(materialButton.J).compareTo(Boolean.valueOf(materialButton2.J));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(materialButtonToggleGroup.indexOfChild(materialButton), materialButtonToggleGroup.indexOfChild(materialButton2));
            default:
                List list = (List) this.f9972w;
                int iIndexOf = list.indexOf(((y5.d) obj).f14918a);
                int iIndexOf2 = list.indexOf(((y5.d) obj2).f14918a);
                if (iIndexOf == -1) {
                    iIndexOf = Integer.MAX_VALUE;
                }
                if (iIndexOf2 == -1) {
                    iIndexOf2 = Integer.MAX_VALUE;
                }
                return Integer.compare(iIndexOf, iIndexOf2);
        }
    }
}
