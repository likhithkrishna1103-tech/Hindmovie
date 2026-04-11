package e5;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends i implements d5.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SQLiteStatement f3807w;

    public j(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f3807w = sQLiteStatement;
    }

    public final int a() {
        return this.f3807w.executeUpdateDelete();
    }
}
