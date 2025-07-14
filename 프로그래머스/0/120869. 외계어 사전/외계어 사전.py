def solution(spell, dic):
    spell_dic = {i : spell.count(i) for i in set(spell)}
    for i in dic:
        if spell_dic == {j : i.count(j)for j in set(i)}:
            return 1
    return 2