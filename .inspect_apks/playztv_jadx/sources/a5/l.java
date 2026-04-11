package a5;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends k implements z4.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SQLiteStatement f570v;

    public l(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f570v = sQLiteStatement;
    }

    public final int a() {
        return this.f570v.executeUpdateDelete();
    }
}
