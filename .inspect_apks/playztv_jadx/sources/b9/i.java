package b9;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1974u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ChipGroup f1975v;

    public i(ChipGroup chipGroup) {
        this.f1975v = chipGroup;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ChipGroup chipGroup = this.f1975v;
        if (view == chipGroup && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                WeakHashMap weakHashMap = o0.f10475a;
                view2.setId(View.generateViewId());
            }
            j9.a aVar = chipGroup.B;
            Chip chip = (Chip) view2;
            aVar.f6831a.put(Integer.valueOf(chip.getId()), chip);
            if (chip.isChecked()) {
                aVar.a(chip);
            }
            chip.setInternalOnCheckedChangeListener(new u5.c(22, aVar));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1974u;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        ChipGroup chipGroup = this.f1975v;
        if (view == chipGroup && (view2 instanceof Chip)) {
            j9.a aVar = chipGroup.B;
            Chip chip = (Chip) view2;
            aVar.getClass();
            chip.setInternalOnCheckedChangeListener(null);
            aVar.f6831a.remove(Integer.valueOf(chip.getId()));
            aVar.f6832b.remove(Integer.valueOf(chip.getId()));
        }
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f1974u;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
