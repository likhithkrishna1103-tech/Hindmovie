package r0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nc.c f11210a;

    public b(nc.c cVar) {
        this.f11210a = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f11210a.equals(((b) obj).f11210a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11210a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z2) {
        v9.j jVar = (v9.j) this.f11210a.f8921v;
        AutoCompleteTextView autoCompleteTextView = jVar.f13358h;
        if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
            return;
        }
        CheckableImageButton checkableImageButton = jVar.f13379d;
        int i = z2 ? 2 : 1;
        WeakHashMap weakHashMap = o0.f10475a;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
