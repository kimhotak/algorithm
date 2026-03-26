def solution(id_pw, db):
    try_id, try_pw = id_pw
    for db_id, db_pw in db:
        if try_id == db_id:
            if try_pw == db_pw:
                return 'login'
            return 'wrong pw'
    return 'fail'