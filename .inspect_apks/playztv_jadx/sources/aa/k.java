package aa;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends c implements ListIterator {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ l f692y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar) {
        super(lVar);
        this.f692y = lVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        l lVar = this.f692y;
        boolean zIsEmpty = lVar.isEmpty();
        b().add(obj);
        lVar.f703z.f761y++;
        if (zIsEmpty) {
            lVar.b();
        }
    }

    public final ListIterator b() {
        a();
        return (ListIterator) this.f647v;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return b().previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, int i) {
        super(lVar, ((List) lVar.f699v).listIterator(i));
        this.f692y = lVar;
    }
}
