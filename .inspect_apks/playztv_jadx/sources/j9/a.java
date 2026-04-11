package j9;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f6831a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f6832b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u5.d f6833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6835e;

    public final boolean a(h hVar) {
        int id2 = hVar.getId();
        Integer numValueOf = Integer.valueOf(id2);
        HashSet hashSet = this.f6832b;
        if (hashSet.contains(numValueOf)) {
            return false;
        }
        h hVar2 = (h) this.f6831a.get(Integer.valueOf(c()));
        if (hVar2 != null) {
            e(hVar2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id2));
        if (!hVar.isChecked()) {
            hVar.setChecked(true);
        }
        return zAdd;
    }

    public final ArrayList b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.f6832b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof h) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int c() {
        if (!this.f6834d) {
            return -1;
        }
        HashSet hashSet = this.f6832b;
        if (hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public final void d() {
        u5.d dVar = this.f6833c;
        if (dVar != null) {
            new HashSet(this.f6832b);
            ChipGroup chipGroup = (ChipGroup) dVar.f12784v;
            b9.h hVar = chipGroup.A;
            if (hVar != null) {
                hVar.d(chipGroup.B.b(chipGroup));
            }
        }
    }

    public final boolean e(h hVar, boolean z2) {
        int id2 = hVar.getId();
        Integer numValueOf = Integer.valueOf(id2);
        HashSet hashSet = this.f6832b;
        if (!hashSet.contains(numValueOf)) {
            return false;
        }
        if (z2 && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id2))) {
            hVar.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id2));
        if (hVar.isChecked()) {
            hVar.setChecked(false);
        }
        return zRemove;
    }
}
