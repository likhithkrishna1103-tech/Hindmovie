package v9;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f13543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f13544w;

    public g(ChipGroup chipGroup) {
        this.f13544w = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f13544w;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                view2.setId(View.generateViewId());
            }
            da.a aVar = chipGroup.C;
            Chip chip = (Chip) view2;
            ((HashMap) aVar.f3564d).put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                aVar.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new pc.c(aVar));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f13543v;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f13544w;
        if (view == chipGroup && (view2 instanceof Chip)) {
            da.a aVar = chipGroup.C;
            Chip chip = (Chip) view2;
            aVar.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            ((HashMap) aVar.f3564d).remove(Integer.valueOf(chip.getId()));
            ((HashSet) aVar.f3565e).remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f13543v;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
